package com.example.widgetpooldashboard

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.widgetpooldashboard.databinding.ActivityMainBinding
import com.pooldashboard.appwidget.DemoAppWidgetProvider
import com.pooldashboard.appwidget.WidgetModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddWidget.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val mAppWidgetManager = getSystemService(
                    AppWidgetManager::class.java
                )
                val myProvider =
                    ComponentName(this@MainActivity, DemoAppWidgetProvider::class.java)
                val b = Bundle()
                b.putString("ggg", "ggg")
                if (mAppWidgetManager.isRequestPinAppWidgetSupported) {
                    val pinnedWidgetCallbackIntent = Intent(
                        this@MainActivity,
                        DemoAppWidgetProvider::class.java
                    )
                    val successCallback = PendingIntent.getBroadcast(
                        this@MainActivity, 0,
                        pinnedWidgetCallbackIntent, PendingIntent.FLAG_IMMUTABLE
                    )
                    mAppWidgetManager.requestPinAppWidget(myProvider, b, successCallback)
                }
            }
        }
        binding.btnAddToList.setOnClickListener {
            addToList()
        }

    }


    private fun addToList() {
        if (binding.edtNameApp.text.isNotEmpty()) {
            val element = WidgetModel(binding.edtNameApp.text.toString(), 1000, null)
            Log.d("data send :  ", element.toString())
            val intent = Intent(AppWidgetManager.ACTION_APPWIDGET_UPDATE)
            intent.component = ComponentName(this, DemoAppWidgetProvider::class.java)
            intent.putExtra("data", element)
            this.sendBroadcast(intent)

        }


    }


}
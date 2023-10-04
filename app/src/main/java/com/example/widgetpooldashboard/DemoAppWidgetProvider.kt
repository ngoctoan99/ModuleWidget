//package com.example.widgetpooldashboard
//
//
//
//import android.app.Activity
//import android.app.PendingIntent
//import android.appwidget.AppWidgetManager
//import android.appwidget.AppWidgetProvider
//import android.content.ActivityNotFoundException
//import android.content.ComponentName
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.net.Uri
//import android.os.Build
//import android.os.Bundle
//import android.text.TextUtils
//import android.util.Log
//import android.widget.RemoteViews
//import com.example.widgetpooldashboard.CustomRemoteViewsFactory.Companion.dataList
//import java.io.Serializable
//
//
//class DemoAppWidgetProvider : AppWidgetProvider(){
//    override fun onUpdate(
//        context: Context?,
//        appWidgetManager: AppWidgetManager?,
//        appWidgetIds: IntArray?
//    ) {
//        for (appWidgetId in appWidgetIds!!) {
//            updateUIWidget(
//                appWidgetId = appWidgetId,
//                context = context,
//                appWidgetManager = appWidgetManager,
//                remoteView = RemoteViews(context!!.packageName,R.layout.example_widget_4_3)
//            )
//            super.onUpdate(context, appWidgetManager, appWidgetIds)
//        }
//    }
//
//    override fun onReceive(context: Context?, intent: Intent?) {
//        super.onReceive(context, intent)
//        if (intent != null) {
//            val action = intent.action;
//            if (!TextUtils.isEmpty(action) && action.equals(AppWidgetManager.ACTION_APPWIDGET_UPDATE)) {
//                if (intent.extras != null) {
//                    Log.i("HHH", "datas: ${intent.serializable<WidgetModel>("data") }")
//                    intent.serializable<WidgetModel>("data")?.let { dataList.add(it) }
//                    val appWidgetManager = AppWidgetManager.getInstance(context)
//                    val appWidgetIds = appWidgetManager.getAppWidgetIds(
//                        ComponentName(
//                            context!!,
//                            DemoAppWidgetProvider::class.java
//                        )
//                    )
//                    for (appWidgetId in appWidgetIds) {
//                        updateUIWidget(appWidgetId,context,appWidgetManager , RemoteViews(context.packageName,R.layout.example_widget_4_3))
//                        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId,R.id.lvInfoPoint)
//                    }
//                }
//            }
//        }
//    }
//
//    override fun onAppWidgetOptionsChanged(
//        context: Context?,
//        appWidgetManager: AppWidgetManager?,
//        appWidgetId: Int,
//        newOptions: Bundle?
//    ) {
//        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions)
//        val minWidth = newOptions!!.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH)
//        val minHeight = newOptions!!.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT)
//       updateUIWidget(appWidgetId,context,appWidgetManager,getRemoteViews(context,minWidth,minHeight))
//
//
//    }
//
//    private fun getRemoteViews(context: Context?, minWidth: Int, minHeight: Int): RemoteViews {
//        Log.d("getRemoteViews", "Height : $minHeight // Width : $minWidth ")
//        return if (minHeight >= 120) {
//            // Get 4 column widget remote view and return
//            RemoteViews(
//                context!!.packageName,
//                R.layout.example_widget_4_3
//            )
//        } else {
//            // Get appropriate remote view.
//            RemoteViews(
//                context!!.packageName,
//                R.layout.example_widget_4_1
//            )
//        }
//
//    }
//    companion object {
//        fun updateUIWidget(
//            appWidgetId: Int,
//            context: Context?,
//            appWidgetManager: AppWidgetManager?,
//            remoteView : RemoteViews
//        ) {
//
//            val intent = Intent(context, MyWidgetService::class.java)
//            val intentMain = Intent(context, MainActivity::class.java)
//            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
//
//            val pendingIntent =
//                PendingIntent.getActivity(context, 0, intentMain, PendingIntent.FLAG_IMMUTABLE)
////            val views  = RemoteViews(context!!.packageName, R.layout.example_widget_4_3)
//            remoteView.setOnClickPendingIntent(R.id.ivPoolDashBoard, pendingIntent)
//            remoteView.setRemoteAdapter(R.id.lvInfoPoint, intent)
//            setViewData(remoteView , context!!)
//            appWidgetManager!!.updateAppWidget(appWidgetId, remoteView)
//        }
//
//        private fun setViewData(views: RemoteViews , context: Context) {
//            views.setImageViewResource(R.id.ivApp1,R.drawable.friendify)
//            views.setImageViewResource(R.id.ivApp2,R.drawable.poolswallet)
//            views.setImageViewResource(R.id.ivApp3,R.drawable.expertt)
//            views.setImageViewResource(R.id.ivApp4,R.drawable.vote)
//            views.setImageViewResource(R.id.ivApp5,R.drawable.vote)
//            views.setImageViewResource(R.id.ivApp6,R.drawable.friendify)
//            views.setImageViewResource(R.id.ivApp7,R.drawable.poolswallet)
//            views.setImageViewResource(R.id.ivApp8,R.drawable.expertt)
//            views.setImageViewResource(R.id.ivApp9,R.drawable.vote)
//            views.setImageViewResource(R.id.ivApp10,R.drawable.vote)
//            views.setTextViewText(R.id.tvEarnPointDay,"16000")
//            views.setTextViewText(R.id.tvNumberItemApp1,"6")
//            views.setTextViewText(R.id.tvNumberItemApp2,"6")
//            views.setTextViewText(R.id.tvNumberItemApp3,"4")
//            views.setTextViewText(R.id.tvNumberItemApp4,"0")
//            views.setTextViewText(R.id.tvTotalApp,"10")
//            views.setTextViewText(R.id.tvTotalPoint,"100000")
//            views.setOnClickPendingIntent(R.id.ivApp1,createPendingIntentToOpenLink(context,Uri.parse("https://play.google.com/store/apps/details?id=friendify.playground"),"friendify.playground"))
//            views.setOnClickPendingIntent(R.id.ivApp2,createPendingIntentToOpenLink(context,Uri.parse("https://play.google.com/store/apps/details?id=com.wallet.pools"),"com.wallet.pools"))
//            views.setOnClickPendingIntent(R.id.ivApp3,createPendingIntentToOpenLink(context,Uri.parse("https://play.google.com/store/apps/details?id=com.expertt.mobile"),"com.expertt.mobile"))
//            views.setOnClickPendingIntent(R.id.ivApp4,createPendingIntentToOpenLink(context,Uri.parse("https://play.google.com/store/apps/details?id=finance.winery.votebattle"),"finance.winery.votebattle"))
//            views.setOnClickPendingIntent(R.id.ivApp5,createPendingIntentToOpenLink(context,Uri.parse("https://play.google.com/store/apps/details?id=finance.winery.votebattle"),"finance.winery.votebattle"))
//            //            val entries = listOf(
////                BarEntry(1f, 10f),
////                BarEntry(2f, 15f),
////                BarEntry(3f, 8f),
////                // Add more entries as needed
////            )
////            val dataSet = BarDataSet(entries, "Data Set 1")
////            dataSet.color = Color.BLUE
////            dataSet.valueTextColor = Color.BLACK
////            val barData = BarData(dataSet)
////
////            val chart = BarChart(context)
////            chart.data = barData
////
////            chart.measure(
////                View.MeasureSpec.makeMeasureSpec(300, View.MeasureSpec.EXACTLY),
////                View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY)
////            )
////            chart.layout(0, 0, chart.measuredWidth, chart.measuredHeight)
////
////            val chartBitmap = chart.chartBitmap
////            views.setImageViewBitmap(R.id.ivChart,chartBitmap)
//        }
//
//        inline fun <reified T : Serializable> Intent.serializable(key: String): T? = when {
//            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getSerializableExtra(key, T::class.java)
//            else -> @Suppress("DEPRECATION") getSerializableExtra(key) as? T
//        }
//
//
//        // Function to create a PendingIntent to start another app
//        fun createPendingIntentToStartApp(context: Context, targetPackageName: String) : PendingIntent {
//            // Create an Intent with the action to launch the target app
//            val launchIntent = context.packageManager.getLaunchIntentForPackage(targetPackageName)
//
//            // Check if the target app exists
//            if (launchIntent != null) {
//                // Create a PendingIntent with the launch Intent
//                return PendingIntent.getActivity(context, 0, launchIntent, PendingIntent.FLAG_UPDATE_CURRENT)
//            } else {
//                // Target app is not installed
//                // You can handle this case accordingly
//                // For example, show a message or take some other action
//                throw PackageManager.NameNotFoundException("Target app not found")
//            }
//        }
//
//
//        // Function to create a PendingIntent to open a link
//        private fun createPendingIntentToOpenLink(context: Context, linkUri: Uri , packageName :String): PendingIntent {
//            return if(checkAppInstall(packageName,context)){
//                val launchIntent = context.packageManager.getLaunchIntentForPackage(packageName)
//                PendingIntent.getActivity(context, 0, launchIntent, PendingIntent.FLAG_IMMUTABLE  or PendingIntent.FLAG_UPDATE_CURRENT)
//            }else {
//                val intent = Intent(Intent.ACTION_VIEW, linkUri)
//                PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE  or PendingIntent.FLAG_UPDATE_CURRENT)
//            }
//        }
//
//        private fun checkAppInstall(uri: String, context: Context): Boolean {
//            val pm = context.packageManager
//            try {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                    pm.getPackageInfo(uri, PackageManager.PackageInfoFlags.of(0.toLong()))
//                } else {
//                    @Suppress("DEPRECATION") pm.getPackageInfo(uri, 0)
//                }
//                return true
//            } catch (e: PackageManager.NameNotFoundException) {
//                e.printStackTrace()
//            }
//            return false
//        }
//
//
//
//        fun Activity.redirectToPlayStore(appPackageName: String) {
//            try {
//                startActivity(
//                    Intent(
//                        Intent.ACTION_VIEW,
//                        Uri.parse("market://details?id=$appPackageName")
//                    )
//                )
//            } catch (exception: ActivityNotFoundException) {
//                startActivity(
//                    Intent(
//                        Intent.ACTION_VIEW,
//                        Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
//                    )
//                )
//            }
//        }
//    }
//
//}

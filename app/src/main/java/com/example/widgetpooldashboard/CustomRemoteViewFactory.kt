//package com.example.widgetpooldashboard
//
//import android.content.Context
//import android.content.Intent
//import android.graphics.Bitmap
//import android.os.Build
//import android.widget.RemoteViews
//import android.widget.RemoteViewsService
//import androidx.core.content.ContextCompat
//import androidx.core.graphics.drawable.toBitmap
//import java.io.Serializable
//
//class CustomRemoteViewsFactory  (private val context: Context , private val intent : Intent) : RemoteViewsService.RemoteViewsFactory {
//
//
//
//
//
//    override fun onCreate() {
//        // Initialize your data here
//        // For example, fetch data from a remote source or database
//        dataList.add(WidgetModel("Friendify",1000 , ContextCompat.getDrawable(context, R.drawable.friendify)))
//        dataList.add(WidgetModel("PoolsWallet",1000,ContextCompat.getDrawable(context, R.drawable.poolswallet)))
//        dataList.add(WidgetModel("Expert-T",1000,ContextCompat.getDrawable(context, R.drawable.expertt)))
//        dataList.add(WidgetModel("Friendify",1000 , ContextCompat.getDrawable(context, R.drawable.friendify)))
//        dataList.add(WidgetModel("Expert-T",1000,ContextCompat.getDrawable(context, R.drawable.expertt)))
//        dataList.add(WidgetModel("PoolsWallet",1000,ContextCompat.getDrawable(context, R.drawable.poolswallet)))
//        dataList.add(WidgetModel("Friendify",1000 , ContextCompat.getDrawable(context, R.drawable.friendify)))
//        dataList.add(WidgetModel("PoolsWallet",1000,ContextCompat.getDrawable(context, R.drawable.poolswallet)))
//        dataList.add(WidgetModel("Friendify",1000 , ContextCompat.getDrawable(context, R.drawable.friendify)))
//        dataList.add(WidgetModel("PoolsWallet",1000,ContextCompat.getDrawable(context, R.drawable.poolswallet)))
//        dataList.add(WidgetModel("Expert-T",1000,ContextCompat.getDrawable(context, R.drawable.expertt)))
//        dataList.add(WidgetModel("Friendify",1000 , ContextCompat.getDrawable(context, R.drawable.friendify)))
//        dataList.add(WidgetModel("Expert-T",1000,ContextCompat.getDrawable(context, R.drawable.expertt)))
//        dataList.add(WidgetModel("PoolsWallet",1000,ContextCompat.getDrawable(context, R.drawable.poolswallet)))
//        dataList.add(WidgetModel("Friendify",1000 , ContextCompat.getDrawable(context, R.drawable.friendify)))
//        dataList.add(WidgetModel("PoolsWallet",1000,ContextCompat.getDrawable(context, R.drawable.poolswallet)))
//    }
//
//
//
//
//    override fun onDataSetChanged() {
//        // Update your data here if needed
//        // For example, fetch updated data from a remote source or database
//
//
//
//    }
//
//    override fun onDestroy() {
//        // Clean up any resources used by the factory
//        dataList.clear()
//    }
//
//    override fun getCount(): Int {
//        return dataList.size
//    }
//
//    override fun getViewAt(position: Int): RemoteViews {
//        val remoteViews = RemoteViews(context.packageName, R.layout.item_info_point_app)
//        remoteViews.setTextViewText(R.id.tvNameApp, dataList[position].nameApp)
//        if (dataList[position].image != null){
//            remoteViews.setImageViewBitmap(R.id.ivIconApp, dataList[position].image!!.toBitmap(200,200,Bitmap.Config.ARGB_8888))
//        }else {
//            remoteViews.setImageViewResource(R.id.ivIconApp,R.drawable.baseline_widgets_24)
//        }
//
//        return remoteViews
//    }
//
//    override fun getLoadingView(): RemoteViews? {
//        // Return a custom loading view if needed
//        return null
//    }
//
//    override fun getViewTypeCount(): Int {
//        // Return the number of view types your ListView has
//        return 1
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun hasStableIds(): Boolean {
//        // Return true if the item IDs are stable
//        return true
//    }
//
//    private inline fun <reified T : Serializable> Intent.serializable(key: String): T? = when {
//        Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getSerializableExtra(key, T::class.java)
//        else -> @Suppress("DEPRECATION") getSerializableExtra(key) as? T
//    }
//
//    companion object{
//        var dataList = mutableListOf<WidgetModel>()
//
//    }
//}

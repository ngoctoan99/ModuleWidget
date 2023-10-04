package com.pooldashboard.appwidget

import android.content.Intent
import android.util.Log
import android.widget.RemoteViewsService

class MyWidgetService:RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        return CustomRemoteViewsFactory(applicationContext , intent!! )
    }
}
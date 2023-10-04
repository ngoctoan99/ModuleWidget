package com.pooldashboard.appwidget

import android.graphics.drawable.Drawable
import java.io.Serializable

data class WidgetModel(
    var nameApp:String? =  "",
    var point:Int? = 0,
    var image: Drawable?
):Serializable
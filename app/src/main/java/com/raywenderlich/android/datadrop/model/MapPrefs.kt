package com.raywenderlich.android.datadrop.model

import android.preference.PreferenceManager
import com.raywenderlich.android.datadrop.app.DataDropApplication

object MapPrefs {

    private const val KEY_MARKER_COLOR = "KEY_MARKER_COLOR"
    private const val KEY_MAP_TYPE = "KEY_MAP_TYPE"

    fun sharedPrefs() = PreferenceManager.getDefaultSharedPreferences(DataDropApplication.getAppContext())

    fun saveMarketColor(marketColor: String) {
        val editor = sharedPrefs().edit()
        editor.putString(KEY_MARKER_COLOR, marketColor).apply()
    }

    fun getMarkerColor(): String = sharedPrefs().getString(KEY_MARKER_COLOR, MarkerColor.RED_COLOR)

    fun saveMapType(mapType: String) {
        sharedPrefs().edit().putString(KEY_MAP_TYPE, mapType).apply()
    }

    fun getMapType(): String = sharedPrefs().getString(KEY_MAP_TYPE, "Normal")

}
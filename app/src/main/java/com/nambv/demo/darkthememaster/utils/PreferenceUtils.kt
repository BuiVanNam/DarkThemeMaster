package com.nambv.demo.darkthememaster.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

/**
 * Created by nambv on 8/20/2020
 */
object PreferenceUtils {

    private const val PREFERENCE_NAME = "com.android.dark_theme_preferences"

    const val PREFERENCE_KEY_THEME = "key_theme"
    const val THEME_LIGHT = 0
    const val THEME_DARK = 1
    const val THEME_SYSTEM = 2 //only available in Android P or higher

    fun getCurrentTheme(context: Context) =
        getAppPrefs(context).getInt(PREFERENCE_KEY_THEME, THEME_LIGHT)

    fun setStableTheme(context: Context, value: Int) =
        getAppPrefs(context).setValue(PREFERENCE_KEY_THEME, value)

    fun getAppPrefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

}

fun SharedPreferences.setValue(key: String, value: Any?) {
    when (value) {
        is String? -> edit(commit = true) { putString(key, value) }
        is Boolean -> edit(commit = true) { putBoolean(key, value) }
        is Float -> edit(commit = true) { putFloat(key, value) }
        is Int -> edit(commit = true) { putInt(key, value) }
        is Long -> edit(commit = true) { putLong(key, value) }
        else -> throw UnsupportedOperationException("Not support type value")
    }
}
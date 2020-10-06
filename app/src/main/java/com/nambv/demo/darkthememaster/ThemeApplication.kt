package com.nambv.demo.darkthememaster

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.nambv.demo.darkthememaster.utils.PreferenceUtils

/**
 * Created by nambv on 10/5/2020
 */
class ThemeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTheme()
    }

    private fun setupTheme() {
        when (PreferenceUtils.getCurrentTheme(this)) {
            PreferenceUtils.THEME_LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            PreferenceUtils.THEME_DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            PreferenceUtils.THEME_SYSTEM -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }

}
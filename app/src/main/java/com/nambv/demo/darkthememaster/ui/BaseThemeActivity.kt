package com.nambv.demo.darkthememaster.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.nambv.demo.darkthememaster.utils.PreferenceUtils

/**
 * Created by nambv on 10/5/2020
 */
abstract class BaseThemeActivity : AppCompatActivity() {

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        PreferenceObserverLifecycle(this, lifecycle).run {
            themeConfigChange = { handleConfigThemeChange() }
        }
    }

    private fun handleConfigThemeChange() {
        when (PreferenceUtils.getCurrentTheme(this)) {
            PreferenceUtils.THEME_LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            PreferenceUtils.THEME_DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            PreferenceUtils.THEME_SYSTEM -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }

}
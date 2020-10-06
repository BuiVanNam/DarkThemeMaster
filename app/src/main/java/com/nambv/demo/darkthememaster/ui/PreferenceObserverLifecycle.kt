package com.nambv.demo.darkthememaster.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.nambv.demo.darkthememaster.utils.PreferenceUtils

class PreferenceObserverLifecycle(private val context: Context, private val lifecycle: Lifecycle) :
    LifecycleObserver, SharedPreferences.OnSharedPreferenceChangeListener {

    private val mPreference = PreferenceUtils.getAppPrefs(context)
    var themeConfigChange: (() -> Unit)? = null

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        mPreference.registerOnSharedPreferenceChangeListener(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        mPreference.unregisterOnSharedPreferenceChangeListener(this)
        lifecycle.removeObserver(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key.equals(PreferenceUtils.PREFERENCE_KEY_THEME)) {
            themeConfigChange?.invoke()
        }
    }

}
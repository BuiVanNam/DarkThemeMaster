package com.nambv.demo.darkthememaster.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nambv.demo.darkthememaster.R
import com.nambv.demo.darkthememaster.utils.PreferenceUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseThemeActivity() {

    override val layoutId: Int = R.layout.activity_main
    private val mMainViewModel: MainViewModel by viewModels()

    private lateinit var mListNewAdapter: ListNewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mListNewAdapter = ListNewAdapter()
        list_new.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mListNewAdapter
            val dividerItemDecoration =
                DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL).apply {
                    setDrawable(ColorDrawable(resources.getColor(R.color.colorDivider)))
                }
            addItemDecoration(dividerItemDecoration)
        }
        subscriberUI()
    }

    private fun subscriberUI() {
        mMainViewModel.listNews.observe(this) {
            mListNewAdapter.updateData(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.theme_app -> {
                handleSelectMenuTheme()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun handleSelectMenuTheme() {
        AlertDialog.Builder(this).run {
            setCancelable(false)
            setTitle(R.string.theme_app)
            var typeTheme = PreferenceUtils.THEME_LIGHT
            setSingleChoiceItems(
                R.array.theme_menu,
                PreferenceUtils.getCurrentTheme(this@MainActivity)
            ) { dialog, which ->
                run {
                    typeTheme = which
                    dialog.dismiss()
                }
            }
            setOnDismissListener {
                PreferenceUtils.setStableTheme(this@MainActivity, typeTheme)
            }
            show()
        }
    }

}
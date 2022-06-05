package com.danendra.lightdarkmode

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawer_menu = findViewById<ImageView>(R.id.drawer_menu)
        val title_bar = findViewById<TextView>(R.id.title_bar)

        var flags = window.decorView.systemUiVisibility

        if (Build.VERSION.SDK_INT >= 23) {
            if (resources.getString(R.string.mode) == "Day") {
                title_bar.visibility = View.VISIBLE
                flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                title_bar.visibility = View.INVISIBLE
                flags = flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            }
            window.decorView.systemUiVisibility = flags
        } else {
            window.statusBarColor = resources.getColor(R.color.dark_grey)
        }

        /* Drawer menu saya jadikan toggle untuk mwngaktifkan Dark Mode dan Light Mode
    bagi yang HP nya belum support Dark Mode, seperti saya :) */

        drawer_menu.setOnClickListener {
            if (resources.getString(R.string.mode) == "Day") {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

    }

    fun apps_button(view: View) {}
    fun games_button(view: View) {}
    fun movies_button(view: View) {}
    fun music_button(view: View) {}
    fun books_button(view: View) {}
    fun news_button(view: View) {}
    fun more_button(view: View) {}

}
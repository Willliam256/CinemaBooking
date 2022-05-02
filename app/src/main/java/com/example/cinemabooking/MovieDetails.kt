package com.example.cinemabooking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class MovieDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details_layout)

        window.decorView.apply { systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }

        val title = intent.getStringExtra("title")
        val subtitle = intent.getStringExtra("subtitle")
        val bgImage = intent.getIntExtra("bgImage", R.drawable.me)
        val moviePoster = intent.getIntExtra("moviePoster", R.drawable.me)

        findViewById<TextView>(R.id.detail_title).text = title
        findViewById<TextView>(R.id.detail_subtitle).text = subtitle
        findViewById<RelativeLayout>(R.id.bg_image2).setBackgroundResource(bgImage)
        findViewById<RelativeLayout>(R.id.movie_poster).setBackgroundResource(moviePoster)
    }
}
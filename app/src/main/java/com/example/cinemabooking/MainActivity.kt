package com.example.cinemabooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recycleView:RecyclerView
    private lateinit var movieArrayList:ArrayList<MovieData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        window.decorView.apply { systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }

        //Data Source
        val imageId = intArrayOf(
            R.drawable.gerard_bg, R.drawable.avatar_bg, R.drawable.the_matrix_bg, R.drawable.venom_bg, R.drawable.force_of_naturebg,
            R.drawable.timeless_bg, R.drawable.boss_level_bg, R.drawable.black_adam_bg
        )
        val moviePoster = intArrayOf(
            R.drawable.gerard_butler, R.drawable.avatar_2, R.drawable.the_matrix, R.drawable.venom, R.drawable.force_of_nature,
            R.drawable.timeless, R.drawable.boss_level, R.drawable.black_dam

        )
        val title = arrayOf(
            "Greenland", "Avatar-2", "The Matrix", "Venom", "Force Of Nature", "Timeless", "Boss Level", "Black Adam"
        )
        val subtitle = arrayOf(
            "Gerard Butler", "The Way Of Avatar", "Resurrection", "Pop Culture Time", "When The Perfect Crime Meets The Perfect Storm",
            "Take A Timeless Journey With The Latest Time Travel", "Running Out Of Times And Lives", "Black Adam"
        )

        recycleView = findViewById(R.id.recyclerview)

        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.setHasFixedSize(true)

        movieArrayList = arrayListOf<MovieData>()

        for (i in title.indices){
            val listRow = MovieData(imageId[i], title[i], subtitle[i])
            movieArrayList.add(listRow)
        }

        var adapter = MyAdapter(movieArrayList)
        recycleView.adapter = adapter

        adapter.setOnItemClickListener(object:MyAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@MainActivity, "Hello William $position", Toast.LENGTH_SHORT).show()

                val i = Intent(this@MainActivity, MovieDetails::class.java)
                i.putExtra("title", movieArrayList[position].movieTitle)
                i.putExtra("subtitle", movieArrayList[position].movieSubtitle)
                i.putExtra("bgImage", movieArrayList[position].image)
                i.putExtra("moviePoster", moviePoster[position])
                startActivity(i)
            }

        })







    }
}
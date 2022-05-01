package com.example.cinemabooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recycleView:RecyclerView
    private lateinit var movieArrayList:ArrayList<MovieData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.apply { systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN }

        //Data Source
        val imageId = intArrayOf(
            R.drawable.ww, R.drawable.newskull, R.drawable.me
        )
        val background = intArrayOf(

        )
        val title = arrayOf(
            "Wonder Woman", "King Kong", "William Is Back"
        )
        val subtitle = arrayOf(
            "Never Play with a woman", "Skull has fallen", "William just looking for his mum"
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
                //i.putExtra("bgImage2", movieArrayList[position].image)
                startActivity(i)
            }

        })







    }
}
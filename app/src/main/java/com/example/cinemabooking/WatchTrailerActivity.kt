package com.example.cinemabooking

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class WatchTrailerActivity : AppCompatActivity() {

    var videoView:VideoView? = null
    var mediaController:MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watch_trailer)

        videoView = findViewById(R.id.videoView)
        videoView!!.setMediaController(mediaController)
        videoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.venom_trailer))
        videoView!!.requestFocus()
        videoView!!.start()

//        val videoView = findViewById<VideoView>(R.id.videoView)
//        videoView.setVideoURI(Uri.parse("android.resource//" + packageName + "/" + R.raw.avatar))
//        videoView.requestFocus()
//        videoView.start()
////        val uri: Uri = Uri.parse(videoPath)
////        videoView.setVideoURI(uri)
//
        val mediaController = MediaController(this)
        videoView!!.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)
    }
}
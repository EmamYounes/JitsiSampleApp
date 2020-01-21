package com.example.jitsisampleapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jitsi.meet.sdk.JitsiMeet
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import java.net.MalformedURLException
import java.net.URL


// Example
//
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startCallBtn.setOnClickListener {
            val intent = Intent(this, JitsiCallActivity::class.java)
            startActivity(intent)
        }
    }

/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize default options for Jitsi Meet conferences.
        // Initialize default options for Jitsi Meet conferences.
        val serverURL: URL
        try {
            serverURL = URL("https://meet.jit.si")
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            throw RuntimeException("Invalid server URL!")
        }
        val defaultOptions = JitsiMeetConferenceOptions.Builder()
            .setServerURL(serverURL)
            .setWelcomePageEnabled(false)
            .build()
        JitsiMeet.setDefaultConferenceOptions(defaultOptions)
        startCallBtn.setOnClickListener {
            val options = JitsiMeetConferenceOptions.Builder()
                .setRoom("testurl")
                .build()
            JitsiMeetActivity.launch(this, options)
        }
    }
*/
}
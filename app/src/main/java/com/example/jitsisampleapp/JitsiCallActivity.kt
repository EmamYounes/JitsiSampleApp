package com.example.jitsisampleapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.facebook.react.modules.core.PermissionListener
import org.jitsi.meet.sdk.*


// Example
//
class JitsiCallActivity : FragmentActivity(), JitsiMeetActivityInterface {

    private var view: JitsiMeetView? = null
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        JitsiMeetActivityDelegate.onActivityResult(
            this, requestCode, resultCode, data
        )
    }

    override fun onBackPressed() {
        JitsiMeetActivityDelegate.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = JitsiMeetView(this)
        val builder = JitsiMeetConferenceOptions.Builder()
            .setRoom("https://meet.jit.si/test123")
        builder.setAudioMuted(false)
        builder.setVideoMuted(true)
        val jitsiMeetUserInfo = JitsiMeetUserInfo()
        jitsiMeetUserInfo.displayName = "Welcome"
        builder.setUserInfo(jitsiMeetUserInfo)
        val options = builder.build()
        view!!.join(options)
        view!!.listener = object : JitsiMeetViewListener {
            override fun onConferenceJoined(map: Map<String, Any>) {
                Log.e("onConferenceJoined", map.toString())
            }

            override fun onConferenceTerminated(map: Map<String, Any>) {
                Log.e("onConferenceTerminated", map.toString())
            }

            override fun onConferenceWillJoin(map: Map<String, Any>) {
                Log.e("onConferenceWillJoin", map.toString())
            }
        }

        setContentView(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        view!!.dispose()
        view = null
        JitsiMeetActivityDelegate.onHostDestroy(this)
    }

    public override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        JitsiMeetActivityDelegate.onNewIntent(intent)
    }

    override fun requestPermissions(permissions: Array<String>, requestCode: Int, listener: PermissionListener) {
        JitsiMeetActivityDelegate.requestPermissions(this, permissions, requestCode, listener)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        JitsiMeetActivityDelegate.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onResume() {
        super.onResume()
        JitsiMeetActivityDelegate.onHostResume(this)
    }

    override fun onStop() {
        super.onStop()
        JitsiMeetActivityDelegate.onHostPause(this)
    }
}
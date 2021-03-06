package com.example.wecareapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class ButtonBreathActivity : AppCompatActivity() {
    var isOn=true
    var seconds=10
    private lateinit var mp: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_breath)

        val breath=findViewById<ImageButton>(R.id.bt_breath)
        var tv_timer=findViewById<TextView>(R.id.tv_timer)

        val timer= object :CountDownTimer(10000,1000){
        override fun onTick(p0: Long) {
            tv_timer.text=seconds.toString()
            seconds--

        }

        override fun onFinish() {
            breath.setImageResource(R.drawable.off)
            isOn=true
            seconds=10
            tv_timer.text=seconds.toString()
        }

    }
    if (seconds==0) timer.onFinish()



        breath.setOnClickListener(View.OnClickListener {

            mp = MediaPlayer.create(this, R.raw.click)
            mp.start()
            if(isOn) {
                breath.setImageResource(R.drawable.on)
                isOn=false
                timer.start()
            }
        })
    }
}
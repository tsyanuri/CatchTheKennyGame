package com.tsyanuri.android.kennygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var Score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Score = 0

        object : CountDownTimer(10000,1000){
            override fun onFinish() {
                textTimer.text = "Timer : Time's Up "
            }

            override fun onTick(millisUntilFinished: Long) {
               textTimer.text = "Timer : " + millisUntilFinished/1000
            }

        }.start()
    }

    fun increaseScore(view: View){
        Score++

        textScore.text = "Score : " + Score
    }
}

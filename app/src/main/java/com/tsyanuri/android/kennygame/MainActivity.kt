package com.tsyanuri.android.kennygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var Score = 0
    var imageArray = ArrayList<ImageView>()
    var handler : Handler = Handler()
    var runnable : Runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Score = 0

        imageArray = arrayListOf(kenny1,kenny2,kenny3,kenny4,kenny5,kenny6,kenny7,kenny8,kenny9)

        hideImage()

        object : CountDownTimer(10000,1000){
            override fun onFinish() {
                textTimer.text = "Time's Up "
                handler.removeCallbacks(runnable)
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
            }

            override fun onTick(millisUntilFinished: Long) {
               textTimer.text = "Timer : " + millisUntilFinished/1000
            }

        }.start()
    }

    fun hideImage(){

        runnable = object : Runnable{
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }
                val randomIndex = Random.nextInt(8-0)
                imageArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }
        }
        handler.post(runnable)
    }

    fun increaseScore(view: View){
        Score++

        textScore.text = "Score : " + Score
    }
}

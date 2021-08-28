package com.example.savourit

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.savourit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding

    override fun onBackPressed() {
        finishAffinity()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.parseColor("#FFFFFFFF")
        }

        binding.logo.animate().translationY(-1400f).setDuration(2000).setStartDelay(3300)

        loginScreen()
    }

    private fun loginScreen() {
        val countDown: CountDownTimer
        countDown = object : CountDownTimer(3500, 1000) {
            override fun onTick(millisecsToFinish: Long) {}
            override fun onFinish() {

                val intent = Intent(this@MainActivity, Home::class.java)
                startActivity(intent);
                overridePendingTransition(R.anim.up, R.anim.nothing)
            }


            }
        countDown.start()
    }

}



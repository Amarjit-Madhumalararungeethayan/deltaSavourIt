package com.example.savourit

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.annotation.RequiresApi
import com.example.savourit.databinding.ActivityMenuBinding
import com.example.savourit.databinding.ActivityTransactionBinding

class Transaction : AppCompatActivity() {

    lateinit var binding: ActivityTransactionBinding

    override fun onBackPressed() {
        finishAffinity()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#676098")
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }

        binding.trans.animate().translationY(1400f).setDuration(500).setStartDelay(3300)
        binding.picc.animate().translationY(1400f).setDuration(500).setStartDelay(3300)
        binding.drop.animate().translationY(1700f).setDuration(900).setStartDelay(3300)

        binding.id1.animate().translationY(1500f).setDuration(900).setStartDelay(3300)
        binding.id2.animate().translationY(1350f).setDuration(900).setStartDelay(3300)
        binding.id3.animate().translationY(2000f).setDuration(900).setStartDelay(3300)
        binding.id4.animate().translationY(1800f).setDuration(900).setStartDelay(3300)

        binding.box.animate().translationY(1600f).setDuration(900).setStartDelay(3300)
        binding.succ.animate().translationY(1600f).setDuration(900).setStartDelay(3300)
        binding.amt.animate().translationY(1600f).setDuration(900).setStartDelay(3300)
        binding.dots.animate().translationY(1600f).setDuration(900).setStartDelay(3300)
        binding.bal.animate().translationY(1600f).setDuration(900).setStartDelay(3300)
        binding.wbox.animate().translationY(1600f).setDuration(900).setStartDelay(3300)
        binding.card.animate().translationY(2400f).setDuration(900).setStartDelay(3300)

        binding.cardy.animate().translationY(1600f).setDuration(900).setStartDelay(3300)
        binding.master.animate().translationY(1600f).setDuration(900).setStartDelay(3300)
        binding.code.animate().translationY(1600f).setDuration(900).setStartDelay(3300)

        binding.card.setOnClickListener(){
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right, R.anim.nothing)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        FullScreencall()
    }

    fun FullScreencall() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            val v = this.window.decorView
            v.systemUiVisibility = View.GONE
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            val decorView = window.decorView
            val uiOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            decorView.systemUiVisibility = uiOptions
        }
    }
}

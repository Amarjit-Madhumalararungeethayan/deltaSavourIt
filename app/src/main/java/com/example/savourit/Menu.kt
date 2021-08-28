package com.example.savourit

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import com.example.savourit.databinding.ActivityMainBinding
import com.example.savourit.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {

    lateinit var binding : ActivityMenuBinding

    override fun onBackPressed() {
        val intent = Intent(this, Home::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.left, R.anim.nothing)
        finish()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#cdcbd9")
        window.decorView.apply {

            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }

        binding.disguise.isVisible = false
        binding.basket.isVisible = false

        binding.demoPic.setOnClickListener(){

            binding.fc2.animate().translationX(200f).setDuration(200)
            binding.demoTitle.animate().translationX(200f).setDuration(200)
            binding.demoDesc.animate().translationX(200f).setDuration(200)
            binding.demoPrice.animate().translationX(1000f).setDuration(200)
            binding.total.text = "Total: \$ 15.70"
            binding.disguise.isVisible = true
            binding.basket.isVisible = true

        }

        binding.card.setOnClickListener(){

            val intent = Intent(this, Transaction::class.java)
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
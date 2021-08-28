package com.example.savourit

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.savourit.databinding.ActivityHomeBinding

var images : ArrayList<Int> = ArrayList()
var info : ArrayList<String> = ArrayList()

class Home : AppCompatActivity() {

    lateinit var binding : ActivityHomeBinding

    override fun onBackPressed() {
        finishAffinity()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#676098")
        window.decorView.apply {

            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }

        images.add(R.drawable.p1)
        images.add(R.drawable.p2)
        images.add(R.drawable.p3)
        images.add(R.drawable.p4)

        info.add("Pizza")
        info.add("Burger")
        info.add("Pasta")
        info.add("Drink")

        val adapter = Adapter(this,images, info)

        // Layout as Staggered Grid for vertical orientation
        val LinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.list.layoutManager = LinearLayoutManager

        binding.list.setNestedScrollingEnabled(false)

        // Adapter to RecyclerView
        binding.list.adapter = adapter

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
package com.example.savourit

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.savourit.databinding.ActivityHomeBinding
import com.example.savourit.databinding.ActivityMainBinding

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

        // Adapter to RecyclerView
        binding.list.adapter = adapter

    }
}
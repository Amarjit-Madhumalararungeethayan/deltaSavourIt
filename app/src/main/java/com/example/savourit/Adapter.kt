package com.example.savourit

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class Adapter(context : Context, images: ArrayList<Int>, info : ArrayList<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var images: ArrayList<Int> = images
    var info: ArrayList<String> = info
    var context: Context

    init {
        this.info = info
        this.images = images
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflating the Layout(Instantiates rv_item.xml layout file into View object)
        val view: View = LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false)

        // Passing view to ViewHolder
        return ViewHolder(view)
    }

    // Binding data to the into specified position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val res = images[position] as Int
        holder.txt.text = "${info[position]}"

        holder.img.setImageResource(res)
    }

    override fun getItemCount(): Int {
        // Returns number of items currently available in Adapter
        return images.size
    }

    // Initializing the Views
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var img: ImageView = view.findViewById(R.id.imageView)
        var txt : TextView = view.findViewById(R.id.name)
/**
        init {
            view.imageView.setOnClickListener { view: View ->

                for(i in 0..171){
                    if(imagesX[i] == images[position]){
                        ID = i
                    }
                }
                val intent = Intent(context, DogGalleryDetails::class.java)
                intent.putExtra("Position",ID)
                val options = ViewCompat.getTransitionName(img)?.let {
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        context as Activity, img,
                        it
                    )
                }
                if (options != null) {
                    context.startActivity(intent, options.toBundle())
                }
            }

        } **/
    }
}
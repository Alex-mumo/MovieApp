package com.example.dagger.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dagger.model.RepositoryData
import com.example.movieapp.R

class RecyclerViewAdapter():RecyclerView.Adapter<RecyclerViewAdapter.AppViewHolder>() {
    private var listData:List<RepositoryData>? = null
    fun setListData(listData:List<RepositoryData>?){
        this.listData = listData
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.AppViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repository_list,parent)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.AppViewHolder, position: Int) {
         holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (listData == null)return 0
        return listData?.size!!
    }
    class AppViewHolder(view : View): RecyclerView.ViewHolder(view) {
         val image = view.findViewById<ImageView>(R.id.image)
         val name = view.findViewById<TextView>(R.id.name)
         val description = view.findViewById<TextView>(R.id.description)

        fun bind(data: RepositoryData){
            name.text = data.name
            description.text = data.description


            Glide.with(image)
                .load(data.owner?.avatar_url)
                .into(image)

        }

    }
}
package com.example.restapiintegration.UserAdapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restapiintegration.R
import com.example.restapiintegration.UserX

class UserAdapter(val users : List<UserX>, val context : Context) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var tv_name = itemView.findViewById<TextView>(R.id.tv_name)
        var tv_id = itemView.findViewById<TextView>(R.id.tv_id)
        var iv_user = itemView.findViewById<ImageView>(R.id.imageView)
        var tv_gender = itemView.findViewById<TextView>(R.id.tv_gender)
        var tv_age = itemView.findViewById<TextView>(R.id.tv_age)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_user,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = users[position]
        holder.tv_name.text = user.firstName + " " + user.lastName
        holder.tv_id.text = user.id.toString()
        holder.tv_gender.text = user.gender
        holder.tv_age.text = user.age.toString()


        Glide.with(context)
            .load(user.image)
            .into(holder.iv_user)
    }
}


package com.example.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.databinding.ItemLyBinding
import com.example.recycler.databinding.UserBinding
import com.squareup.picasso.Picasso

class UserAdapter(val beseList: List<MovieModel>,val itemCallback: OnItemCallback):RecyclerView.Adapter<UserAdapter.ItemHolder>(){
    inner class ItemHolder(val b: UserBinding):RecyclerView.ViewHolder(b.root){
        fun bind(itemData: MovieModel){
            b.titleId.text = itemData.name
            b.recycler.layoutManager = LinearLayoutManager(b.root.context, LinearLayoutManager.HORIZONTAL, false)
            b.recycler.adapter = SubMemberAdapter(beseList)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(UserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
       val itemData=beseList[position]
        holder.bind(itemData)
//        holder.itemView.findViewById<TextView>(R.id.text1).text = itemData.text
//        holder.itemView.findViewById<ImageView>(R.id.imageView).setImageResource(itemData.img)

        holder.itemView.setOnClickListener {
            itemCallback.subMemberItemClick(itemData)
        }

    }

    override fun getItemCount(): Int {
      return beseList.size
    }
}

interface OnItemCallback{
    fun subMemberItemClick(s:MovieModel)
}
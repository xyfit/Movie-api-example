package com.example.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.databinding.ItemLyBinding
import com.squareup.picasso.Picasso


class SubMemberAdapter(val beseList: List<MovieModel>): RecyclerView.Adapter<SubMemberAdapter.ItemHolder>(){
    inner class ItemHolder(val b: ItemLyBinding):RecyclerView.ViewHolder(b.root){

    fun bind(itemData: MovieModel){
        Picasso.get().load(itemData.imageUrl).into(b.image);
        b.text1.text = itemData.name
    }
}
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData=beseList[position]
        holder.bind(itemData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int,): ItemHolder {
        return ItemHolder(ItemLyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return beseList.size
    }
}
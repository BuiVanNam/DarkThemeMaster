package com.nambv.demo.darkthememaster.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nambv.demo.darkthememaster.R
import com.nambv.demo.darkthememaster.source.model.New

/**
 * Created by nambv on 10/5/2020
 */
class ListNewAdapter : RecyclerView.Adapter<ItemNewViewHolder>() {

    private val mListNews = ArrayList<New>()

    fun updateData(newList: List<New>) {
        mListNews.clear()
        mListNews.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemNewViewHolder {
        return ItemNewViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_new, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mListNews.size
    }

    override fun onBindViewHolder(holder: ItemNewViewHolder, position: Int) {
        holder.bindItem(mListNews[position])
    }

}
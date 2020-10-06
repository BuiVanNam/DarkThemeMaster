package com.nambv.demo.darkthememaster.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nambv.demo.darkthememaster.source.model.New
import kotlinx.android.synthetic.main.item_new.view.*

class ItemNewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindItem(itemNew: New?) {
        itemNew?.run {
            itemView.title_new.text = title
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(RequestOptions().centerCrop())
                .load(image)
                .into(itemView.image_new)
        }
    }

}
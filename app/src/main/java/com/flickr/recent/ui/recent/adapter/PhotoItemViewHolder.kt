package com.flickr.recent.ui.recent.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.flickr.recent.data.entitiy.Photo
import com.flickr.recent.databinding.ItemPhotoViewHolderBinding
import com.flickr.recent.extension.gone


class PhotoItemViewHolder(private val binding: ItemPhotoViewHolderBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(photo: Photo, onItemClickListener: ((Photo) -> Unit)? = null) {

        binding.run {

            root.setOnClickListener {
                onItemClickListener?.invoke(photo)
            }

            photo.title?.let { title ->

                if (title.isNotEmpty())
                    textViewTitle.text = title
                else
                    textViewTitle.gone()

            } ?: textViewTitle.gone()


            Glide.with(binding.root).load(photo.thumbnailUrl)
                .transition(crossFade)
                .into(imageViewThumbnail)
        }
    }

    companion object {
        val crossFade = DrawableTransitionOptions().crossFade(300)
    }
}



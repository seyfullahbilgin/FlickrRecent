package com.flickr.recent.ui.recent.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

import com.flickr.recent.data.entitiy.Photo
import com.flickr.recent.databinding.ItemPhotoViewHolderBinding
import javax.inject.Inject


class PhotoAdapter
@Inject
constructor() : PagedListAdapter<Photo, PhotoItemViewHolder>(DIFF_CALLBACK) {

    private var onItemClickListener: ((Photo) -> Unit)? = null

    fun setOnItemClickListener(listener: (Photo) -> Unit) {
        this.onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoItemViewHolder {
        val binding =
            ItemPhotoViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoItemViewHolder, position: Int) {
        getItem(position)?.let { photo ->
            holder.bind(photo, onItemClickListener)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Photo>() {
            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean =
                oldItem.id == newItem.id
        }
    }
}

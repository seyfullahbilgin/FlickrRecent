package com.flickr.recent.ui.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.flickr.recent.databinding.FragmentPhotoBinding
import dagger.android.support.DaggerFragment

class PhotoFragment : DaggerFragment() {

    private val args: PhotoFragmentArgs by navArgs()
    private lateinit var binding: FragmentPhotoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bigPhotoUrl = args.bigPhotoUrl

        binding.run {
            Glide.with(view.context).load(bigPhotoUrl)
                .apply(RequestOptions.timeoutOf(1 * 60 * 1000))
                .into(imageViewPhoto)
        }
    }
}


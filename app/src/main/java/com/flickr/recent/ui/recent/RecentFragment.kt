package com.flickr.recent.ui.recent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.flickr.recent.databinding.FragmentRecentBinding
import com.flickr.recent.extension.createViewModel
import com.flickr.recent.extension.delay
import com.flickr.recent.extension.navigate
import com.flickr.recent.ui.recent.adapter.PhotoAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Provider

class RecentFragment : DaggerFragment(), SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var photoAdapter: PhotoAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var staggeredGridLayoutManagerProvider: Provider<StaggeredGridLayoutManager>

    private lateinit var viewModel: RecentViewModel
    private lateinit var binding: FragmentRecentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = createViewModel(viewModelFactory)

        binding.swipeRefreshLayout.setOnRefreshListener(this)

        initRecyclerView()
        getRecent()
    }

    private fun initRecyclerView() {
        binding.recyclerViewRecent.apply {
            adapter = photoAdapter
            layoutManager = staggeredGridLayoutManagerProvider.get()
        }
    }


    private fun getRecent(isCached: Boolean = true) {

        if (!isCached) {
            binding.swipeRefreshLayout.isRefreshing = true

            delay(1000) {
                binding.swipeRefreshLayout.isRefreshing = false
            }
        }

        viewModel.getRecent(isCached)?.observe(viewLifecycleOwner, Observer { photos ->
            photoAdapter.apply {
                submitList(photos)
                setOnItemClickListener { photo ->
                    navigate(RecentFragmentDirections.actionRecentFragmentToPhotoFragment(photo.bigPhotoUrl))
                }
            }
        })
    }

    override fun onRefresh() {
        getRecent(false)
    }
}


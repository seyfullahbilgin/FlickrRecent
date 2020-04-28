package com.flickr.recent.extension

import androidx.lifecycle.ViewModel
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController


fun Fragment.navigate(navDirections: NavDirections) = findNavController().navigate(navDirections)

inline fun <reified VM : ViewModel> Fragment.createViewModel(factory: ViewModelProvider.Factory): VM {
    return ViewModelProvider(this, factory).get(VM::class.java)
}




package com.patikadev.mvvmsample.util

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


fun Fragment.showToast(messageToShow : String){
    Toast.makeText(requireContext(), messageToShow, Toast.LENGTH_LONG).show()
}

inline fun<reified T : ViewModel> Fragment.getViewModelHolder() : T{

    return ViewModelProvider(this).get(T::class.java)
}
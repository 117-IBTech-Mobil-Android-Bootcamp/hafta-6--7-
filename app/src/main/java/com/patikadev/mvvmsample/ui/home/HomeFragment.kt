package com.patikadev.mvvmsample.ui.home

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.patikadev.mvvmsample.R
import com.patikadev.mvvmsample.base.BaseFragment
import com.patikadev.mvvmsample.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel,  FragmentHomeBinding>() {
    override val mviewModel: HomeViewModel by viewModel()

    override fun getLayoutID(): Int = R.layout.fragment_home

    override fun prepareView() {
       dataBinding.buttonNextFragment.setOnClickListener {
           findNavController().navigate(R.id.action_homeFragment_to_filmListFragment)
       }
    }


    override fun shouldCheckInternetConnection() = false

    override fun observeLiveData() {

    }


}
package com.patikadev.mvvmsample.ui.filmlist

import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import com.patikadev.mvvmsample.R
import com.patikadev.mvvmsample.base.BaseFragment
import com.patikadev.mvvmsample.databinding.FragmentMovieListBinding
import com.patikadev.mvvmsample.ui.filmlist.adapter.MovieListAdapter
import com.patikadev.mvvmsample.util.showToast
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MovieListFragment : BaseFragment<MovieListViewModel, FragmentMovieListBinding>() {


    override val mviewModel: MovieListViewModel by viewModel()


    override fun getLayoutID() = R.layout.fragment_movie_list

    override fun prepareView() {


        Log.e("prepareview", "çalıştı")
        lifecycleScope.launch {
            doSometing()
        }

        Log.e("prepareview devam", "etti")


        /* myRespnse.types.forEach{ it ->
             val view : View = LayoutInflater.from(requireContext()).inflate(R.layout.row_type, dataBinding.container, false)
             val nameTV = view.findViewById<TextView>(R.id.nameTV)

             nameTV.text = it.name

             dataBinding.container.addView(view)
         }*/
    }

    suspend fun doSometing() {
        Log.e("dosomething", "bitti")
        val imageview : ImageView

    }


    override fun observeLiveData() {

        mviewModel.prepareMovies()


        mviewModel.onMoviesFetched.observe(this, {
            dataBinding.movieListViewState = it
            dataBinding.executePendingBindings()

            dataBinding.recyclerView.adapter = MovieListAdapter(it.getList())

        })


        mviewModel.onError.observe(this, {

           showToast("Bir hata meydana geldi")

        })
    }



}
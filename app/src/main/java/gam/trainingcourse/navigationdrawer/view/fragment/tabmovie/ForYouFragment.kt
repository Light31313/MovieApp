package gam.trainingcourse.navigationdrawer.view.fragment.tabmovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import gam.trainingcourse.navigationdrawer.adapter.GenreAdapter
import gam.trainingcourse.navigationdrawer.adapter.MovieAdapter
import gam.trainingcourse.navigationdrawer.databinding.FragmentForYouBinding
import gam.trainingcourse.navigationdrawer.viewmodel.ForYouViewModel


class ForYouFragment : Fragment() {

    private lateinit var binding: FragmentForYouBinding
    private lateinit var popularMoviesAdapter: MovieAdapter
    private lateinit var topRatedMoviesAdapter: MovieAdapter
    private lateinit var genreAdapter: GenreAdapter

    private val viewModel: ForYouViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForYouBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
    }


    private fun initComponent() {
        popularMoviesAdapter = MovieAdapter(activity!!, viewModel.popularMovies)
        topRatedMoviesAdapter = MovieAdapter(activity!!, viewModel.topRatedMovies)
        binding.rvNewRelease.adapter = popularMoviesAdapter
        binding.rvBollywood.adapter = topRatedMoviesAdapter
        initMovies()

        viewModel.initGenres(context!!)
        genreAdapter = GenreAdapter(viewModel.genres)
        binding.rvGeners.adapter = genreAdapter
    }


    private fun initMovies() {
        viewModel.initPopularMovie(context!!, popularMoviesAdapter)
        viewModel.initTopRatedMovie(context!!, topRatedMoviesAdapter)
    }


}
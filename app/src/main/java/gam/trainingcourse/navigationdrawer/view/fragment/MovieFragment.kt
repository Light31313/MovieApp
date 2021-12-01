package gam.trainingcourse.navigationdrawer.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import gam.trainingcourse.navigationdrawer.R
import gam.trainingcourse.navigationdrawer.adapter.MovieFragmentAdapter
import gam.trainingcourse.navigationdrawer.databinding.FragmentMovieBinding


class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var tabs : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MovieFragmentAdapter(this)
        binding.vpMovie.adapter = adapter
        tabs = resources.getStringArray(R.array.tabs)
        TabLayoutMediator(binding.tlMovie, binding.vpMovie) { tab, position ->
            tab.text = tabs[position]
        }.attach()
    }

}
package gam.trainingcourse.navigationdrawer.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gam.trainingcourse.navigationdrawer.databinding.FragmentMusicBinding


class MusicFragment : Fragment() {

    private lateinit var binding: FragmentMusicBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}
package gam.trainingcourse.navigationdrawer.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gam.trainingcourse.navigationdrawer.databinding.FragmentBookBinding


class BookFragment : Fragment() {

    private lateinit var binding: FragmentBookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}
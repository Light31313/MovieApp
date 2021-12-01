package gam.trainingcourse.navigationdrawer.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import gam.trainingcourse.navigationdrawer.view.fragment.tabmovie.*


class MovieFragmentAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ForYouFragment()
            1 -> TopSellingFragment()
            2 -> NewReleasesFragment()
            3 -> GenersFragment()
            4 -> StudyFragment()
            else -> ForYouFragment()
        }
    }
}
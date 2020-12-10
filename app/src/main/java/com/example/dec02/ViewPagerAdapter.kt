package com.example.dec02

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dec02.homeNavComponent.HomeFragment
import com.example.dec02.homeViewpagerComponent.BestFragment
import com.example.dec02.homeViewpagerComponent.HotDealFragment
import com.example.dec02.homeViewpagerComponent.NewFragment
import com.example.dec02.homeViewpagerComponent.TodayFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int =4
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->TodayFragment()
            1->NewFragment()
            2->BestFragment()
            3->HotDealFragment()
            else-> HomeFragment()
        }
    }
}
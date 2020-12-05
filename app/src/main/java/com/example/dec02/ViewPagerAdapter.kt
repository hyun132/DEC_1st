package com.example.dec02

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dec02.home.BestFragment
import com.example.dec02.home.HotDealFragment
import com.example.dec02.home.NewFragment
import com.example.dec02.home.TodayFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int =4
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->TodayFragment()
            1->NewFragment()
            2->BestFragment()
            3->HotDealFragment()
            else->HomeFragment()
        }
    }

}
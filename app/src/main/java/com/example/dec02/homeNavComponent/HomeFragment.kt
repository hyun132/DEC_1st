package com.example.dec02.homeNavComponent

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.dec02.R
import com.example.dec02.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    private lateinit var myViewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        myViewPagerAdapter = ViewPagerAdapter(activity!!)   //이 프래그먼트에 뷰페이저 어답터 생성.
        viewPager = view.findViewById(R.id.home_ViewPager)
        viewPager.adapter = myViewPagerAdapter  //viewPager에 Adapter 연결해줌.

        val tabLayout = view.findViewById<TabLayout>(R.id.home_tabLayout)   //fragment이기 때문에 root view에서 위젯 가져와야함.
        val tabLayoutTextArray= arrayListOf<String>("투데이","NEW","BEST","핫딜")    //tab이름 설정
        TabLayoutMediator(tabLayout, home_ViewPager) { tab, position ->         //tabLayout과 ViewPager를 연결해줌.
            tab.text=tabLayoutTextArray[position]
        }.attach()
    }

}
package com.example.dec02.homeViewpagerComponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.dec02.R
import kotlinx.android.synthetic.main.fragment_today_pager_slider.*
import kotlinx.android.synthetic.main.fragment_today_pager_slider.view.*


class TodayPagerSliderFragment(val position:Int) : Fragment() {
    val imageUri= arrayOf("https://file.mk.co.kr/mkde_7/N0/2019/10/20191015_4262230_1571105693.jpg","https://cdn.pixabay.com/photo/2020/04/24/08/57/street-5085971__340.jpg",
        "https://cdn.pixabay.com/photo/2020/03/11/01/53/landscape-4920705__340.jpg")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_today_pager_slider, container, false)

        Glide.with(activity!!).load(imageUri[position]).into(view.sliding_image)

        return view
    }
}
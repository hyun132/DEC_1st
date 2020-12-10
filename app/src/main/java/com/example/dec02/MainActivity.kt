package com.example.dec02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.dec02.homeNavComponent.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.search_toobar_layout.*
import kotlinx.android.synthetic.main.splash.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.splash)
        val splash_anim = AnimationUtils.loadAnimation(this, R.anim.splash_slide_up)

        main_title.startAnimation(splash_anim)
        subtitle.visibility = View.INVISIBLE
        Handler().postDelayed({
            main_title.clearAnimation()
            subtitle.startAnimation(splash_anim)
            subtitle.visibility = View.VISIBLE
        }, 1500)

        Handler().postDelayed({
            setContentView(R.layout.activity_main)
            replaceFragment(HomeFragment())
            home_bottom_nav.setOnNavigationItemSelectedListener(bottomNavigationItemSelectedListener)
        }, 4000)

    }

    //buttom Navigation로 화면 전환(https://material.io/develop/android/components/bottom-navigation)
    val bottomNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_favorit -> {
                    replaceFragment(FavoriteFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_market -> {
                    replaceFragment(MarketFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_style -> {
                    replaceFragment(StyleFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_mypage -> {
                    replaceFragment(MypageFragment())
                    return@OnNavigationItemSelectedListener true
                }
                else -> false
            }
        }

    fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home_nav_frame, fragment)
        fragmentTransaction.commit()
    }
}
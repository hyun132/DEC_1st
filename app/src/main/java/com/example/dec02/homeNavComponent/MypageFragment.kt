package com.example.dec02.homeNavComponent

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.dec02.LoginActivity
import com.example.dec02.R

class MypageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)

        val button = view.findViewById<Button>(R.id.mypage_login_btn)   //여기서는 root view 를 통해서 위젯에 접근해야함.
        button.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java) // Fragment에서는 this 대신 getActivity로 context 가져올 수 있다.
            startActivity(intent)
        }
        return view
    }
}
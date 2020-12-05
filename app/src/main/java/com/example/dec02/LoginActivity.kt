package com.example.dec02

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_mypage.view.*
import kotlin.math.log

class LoginActivity : AppCompatActivity() {

    companion object{
        lateinit var sharedPreferences:SharedPreferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val sharedpref = this.getSharedPreferences("email",Context.MODE_PRIVATE)
//        val sharedpref=getSharedPreferences("email",Context.MODE_PRIVATE)

        if (sharedpref.getString("email",null)!==null){
            login_email_et.setText(sharedpref.getString("email",null).toString())
        }

        login_btn.setOnClickListener {
            val editor= sharedpref.edit()
            Log.d("LoginActivity","로그인버튼 클릭")
            if (!login_email_et.text.isNullOrBlank() && !login_password_et.text.isNullOrBlank()){
                editor.putString("email",login_email_et.text.toString())
                editor.commit()
            }
        }

    }
}
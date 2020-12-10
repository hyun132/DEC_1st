package com.example.dec02.homeViewpagerComponent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.dec02.R
import kotlinx.android.synthetic.main.activity_shopping_mall.*

class ShoppingMallActivity : AppCompatActivity() {

    lateinit var webSetting :WebSettings
    lateinit var shoppingmall_webview:WebView
    lateinit var uri:String

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_mall)



        shoppingmall_webview=findViewById(R.id.shoppingmall_webview)
//        shoppingmall_webview.settings.javaScriptEnabled=true
//        shoppingmall_webview.webViewClient = WebViewClient() // 클릭시 새창 안뜨게
//        webSetting = shoppingmall_webview.settings //세부 세팅 등록
////        shoppingmall_webview.webViewClient= WebViewClient()
////        val webSetting=shoppingmall_webview.settings
        shoppingmall_webview.settings.apply {

            javaScriptEnabled = true // 웹페이지 자바스클비트 허용 여부
            setSupportMultipleWindows(false) // 새창 띄우기 허용 여부
//            javaScriptCanOpenWindowsAutomatically = false // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
            loadWithOverviewMode = true // 메타태그 허용 여부
            useWideViewPort = true // 화면 사이즈 맞추기 허용 여부
            setSupportZoom(false) // 화면 줌 허용 여부
            builtInZoomControls = false // 화면 확대 축소 허용 여부
            layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN // 컨텐츠 사이즈 맞추기
            cacheMode = WebSettings.LOAD_NO_CACHE // 브라우저 캐시 허용 여부
            domStorageEnabled = true // 로컬저장소 허용 여부

        }

        uri= intent.getStringExtra("uri").toString()
        Log.d("get:",uri)
        shoppingmall_webview.loadUrl(uri)

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
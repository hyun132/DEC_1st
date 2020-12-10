package com.example.dec02.homeViewpagerComponent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.dec02.ClothesData
import com.example.dec02.R
import kotlinx.android.synthetic.main.fragment_today.*
import kotlinx.android.synthetic.main.fragment_today.view.*

class TodayFragment : Fragment() {

    private lateinit var todayViewPagerAdapter: TodayPagerAdapter
    private lateinit var viewPager: ViewPager2

    val clothesItem= arrayOf(
        ClothesData("1","73%","810","블루시티","[겨울집게핀27종] 메리 윈터 양털 집게핀","17711","acc","","https://image.brandi.me/cproduct/2020/11/25/24384152_1606290015_image1_M.jpg","http://bluecityjewelry.com/product/%EA%B2%A8%EC%9A%B8%EC%A7%91%EA%B2%8C%ED%95%8020%EC%A2%85-%EB%A9%94%EB%A6%AC-%EC%9C%88%ED%84%B0-%EC%96%91%ED%84%B8-%EB%BD%80%EA%B8%80%EC%9D%B4-%EB%B0%8D%ED%81%AC-%ED%8D%BC-%EB%B2%A8%EB%B2%B3-%ED%97%A4%EC%96%B4-%EC%A7%91%EA%B2%8C%ED%95%80-%EB%AA%A8%EC%9D%8C-100color/2927/category/1/display/2/",false),
        ClothesData("2","10%","39,800","쇼퍼랜드","[무료배송]무드 빈티지 카라 니트 가디건 (2color)","805","acc","","http://shopperland.co.kr/web/product/big/202011/43bfbb01e3e3f8041b3a1570554a6a34.webp","http://shopperland.co.kr/product/%EB%AC%B4%EB%A3%8C%EB%B0%B0%EC%86%A1%EB%AC%B4%EB%93%9C-%EB%B9%88%ED%8B%B0%EC%A7%80-%EC%B9%B4%EB%9D%BC-%EB%8B%88%ED%8A%B8-%EA%B0%80%EB%94%94%EA%B1%B4-2color/11501/",false),
        ClothesData("3","","30,000","쇼퍼랜드","[굿원단] 3G 왕도톰 브이넥 벌룬 니트","17711","top","top","https://creamcheese.co.kr/web/product/big/202011/8ed7416d738ba2b7949d6214b066ed61.webp","https://creamcheese.co.kr/product/detail.html?product_no=2496&cate_no=45&display_group=1",false),
        ClothesData("4","","23,000","슬로우앤드","[당일발송] #SLOWMADE. 소프티 도톰 브이넥니트 - 5 color","5471","top","","https://www.slowand.com/web/product/big/202010/577753fa21f098caa10749714663b458.webp","https://www.slowand.com/product/slowmade-%EC%86%8C%ED%94%84%ED%8B%B0-%EB%8F%84%ED%86%B0-%EB%B8%8C%EC%9D%B4%EB%84%A5%EB%8B%88%ED%8A%B8-4-color/4549/category/25/display/2/?page_6=11",false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        todayViewPagerAdapter = TodayPagerAdapter(this)   //이 프래그먼트에 뷰페이저 어답터 생성.

        viewPager = view.today_viewpager
        viewPager.adapter = todayViewPagerAdapter  //viewPager에 Adapter 연결해줌.

        today_recyclerview.layoutManager=GridLayoutManager(this.context,2)
        val clothesRecyclerViewAdapter=ClothesRecyclerViewAdapter(clothesItem)
        today_recyclerview.adapter=clothesRecyclerViewAdapter

        clothesRecyclerViewAdapter.setItemClickListener(object :ClothesRecyclerViewAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val intent=Intent(activity,ShoppingMallActivity::class.java)
                intent.putExtra("uri",clothesItem[position].detail_url)
                Log.d("TodayFragment", intent.getStringExtra("uri")!!)
                startActivity(intent)

            }
        })
    }

}
class TodayPagerAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int =4
    override fun createFragment(position: Int): Fragment {
        return TodayPagerSliderFragment(position)
    }
}
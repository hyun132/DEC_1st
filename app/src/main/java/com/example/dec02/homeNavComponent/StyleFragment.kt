package com.example.dec02.homeNavComponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dec02.*
import kotlinx.android.synthetic.main.fragment_market.view.*

class StyleFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var myDataset: Array<StyleData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myDataset = arrayOf(
            StyleData("https://i.ytimg.com/an_webp/TY6qrp1Dp-U/mqdefault_6s.webp?du=3000&sqp=CI7Zx_4F&rs=AOn4CLBSOmuQwcvBsHTXjIay-1mmbjaSgQ","에이블리 텔레비젼","에이블리 사내 최초공개! 과장님 디스하고 싶어 찍은 몰카영상\uD83D\uDE01\n"),
            StyleData("https://i.ytimg.com/an_webp/Aipryw-q1f4/mqdefault_6s.webp?du=3000&sqp=CIS-x_4F&rs=AOn4CLCUSaBYCwVJXFv9f19SuvDC45pDvQ","미니월드","겨울 아우터 코디 대방출\uD83D\uDE4C 데일리하고 힙한 스트릿 코디 in ably (+할인쿠폰 있어요!)\n"),
            StyleData("https://usercontents-c.styleshare.io/images/35835648/640x-","작성자","titletitle"),
            StyleData("https://usercontents-c.styleshare.io/images/35835651/640x-","작성자a","titletitle"),
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_style, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val actionbar = activity!!.actionBar
//        actionbar?.title = "12월2주차 랭킹"

        viewManager = LinearLayoutManager(activity)
        viewAdapter = StyleAdapter(myDataset)

        recyclerView = view.findViewById<RecyclerView>(R.id.style_recyclerview).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }
}
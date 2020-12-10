package com.example.dec02.homeNavComponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dec02.BottomSheetDialog
import com.example.dec02.MarketAdapter
import com.example.dec02.R
import com.example.dec02.marketData
import kotlinx.android.synthetic.main.fragment_market.view.*

class MarketFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
private lateinit var viewAdapter: RecyclerView.Adapter<*>
private lateinit var viewManager: RecyclerView.LayoutManager
private lateinit var myDataset: Array<marketData>

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    myDataset = arrayOf(marketData("크림치즈마켓","#10대 #20대 #심플베이직 러블리","https://m.creamcheese.co.kr/web/product/extra/big/201908/9e538327295610d77a13c7898739e7f3.jpeg","https://creamcheese.co.kr/web/product/big/202010/379b25a138fc3b2cd27815a7d24c9266.gif","https://www.creamcheese.co.kr/web/product/big/202008/b3af27f0d01daf470b772af3c01b0237.gif"),
        marketData("슈가파우더","#10대 #20대 #심플베이직 러블리","https://image.brandi.me/cproductdetail/2020/09/04/96d6a604fac16e0392794f1eb7b5afdf.jpeg","https://creamcheese.co.kr/web/product/big/202010/379b25a138fc3b2cd27815a7d24c9266.gif","https://www.creamcheese.co.kr/web/product/big/202008/b3af27f0d01daf470b772af3c01b0237.gif"),
        marketData("럽앤썸","#10대 #20대 #심플베이직 러블리","https://usercontents-c.styleshare.io/images/35835648/640x-","https://creamcheese.co.kr/web/product/big/202010/379b25a138fc3b2cd27815a7d24c9266.gif","https://www.creamcheese.co.kr/web/product/big/202008/b3af27f0d01daf470b772af3c01b0237.gif"),
        marketData("베이델리","#10대 #20대 #심플베이직 러블리","https://usercontents-c.styleshare.io/images/35835651/640x-","https://creamcheese.co.kr/web/product/big/202010/379b25a138fc3b2cd27815a7d24c9266.gif","https://www.creamcheese.co.kr/web/product/big/202008/b3af27f0d01daf470b772af3c01b0237.gif"),
    )
}

override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    return inflater.inflate(R.layout.fragment_market, container, false)
}

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
//        val actionbar = activity!!.actionBar
//        actionbar?.title = "12월2주차 랭킹"

    view.market_category.setOnClickListener {
        val bottomSheetDialog = BottomSheetDialog()
        bottomSheetDialog.show(activity!!.supportFragmentManager, "categoryBottomSheet")
    }

    viewManager = LinearLayoutManager(activity)
    viewAdapter = MarketAdapter(myDataset)

    recyclerView = view.findViewById<RecyclerView>(R.id.market_recyclerview).apply {
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
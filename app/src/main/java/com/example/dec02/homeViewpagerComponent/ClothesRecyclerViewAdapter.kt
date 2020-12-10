package com.example.dec02.homeViewpagerComponent

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dec02.ClothesData
import com.example.dec02.R
import com.example.dec02.marketData
import kotlinx.android.synthetic.main.clothes_item.view.*

class ClothesRecyclerViewAdapter(private val myDataset: Array<ClothesData>): RecyclerView.Adapter<ClothesRecyclerViewAdapter.ClothesViewHolder>(){

//    private lateinit var itemListener:AdapterView.OnItemClickListener

    class ClothesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val item_thumbnail = itemView.clothes_imageview
        private val item_discount_percent_textview=itemView.discount_percent_textview
        private val item_price=itemView.clothes_price
        private val item_market_name=itemView.clothes_market_name
        private val item_name=itemView.clothes_item_name
        private val item_salesrate=itemView.clothes_item_salesrate
        private val item_liked=itemView.clothes_liked

        fun bind(item: ClothesData) {
            item_discount_percent_textview.text =item.discount_rate
            item_price.text=item.price
            item_market_name.text=item.market_name
            item_name.text=item.item_name
            item_salesrate.text="${item.sales_rate}개 판매중"
            Glide.with(itemView.rootView.context).load(item.thumbnail_url).into(item_thumbnail)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClothesRecyclerViewAdapter.ClothesViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.clothes_item, parent, false)
        // set the view's size, margins, paddings and layout parameters

//        view.setOnClickListener {
//            val intent=Intent(view.context,ShoppingMallFragment::class.java)
//            intent.putExtra("uri",item)
//        }

        return ClothesViewHolder(view)
    }


    //클릭 인터페이스 정의
    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    //클릭리스너 선언
    private lateinit var itemClickListner: ItemClickListener

    //클릭리스너 등록 매소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ClothesViewHolder, position: Int) { //item view와 data 연결
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.bind(myDataset[position])

        holder.itemView.setOnClickListener {    //view에 리스너 달고
            itemClickListner.onClick(it,position)   //위에서 만든 리스너 연결
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}
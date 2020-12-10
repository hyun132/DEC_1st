package com.example.dec02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.market_item.view.*

class MarketAdapter(private val myDataset: Array<marketData>) :
    RecyclerView.Adapter<MarketAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val market_name = itemView.market_name
        private val market_tag =itemView.market_tag
        private val market_rank=itemView.rank_textview
        private val market_iamge1=itemView.image_1
        private val market_iamge2=itemView.image_2
        private val market_iamge3=itemView.image_3

        fun bind(item: marketData) {
            market_name.text = item.title
            market_tag.text=item.tag
            Glide.with(itemView.rootView.context).load(item.image1).into(market_iamge1)
            Glide.with(itemView.rootView.context).load(item.image2).into(market_iamge2)
            Glide.with(itemView.rootView.context).load(item.image3).into(market_iamge3)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarketAdapter.MyViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.market_item, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) { //item view와 data 연결
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.bind(myDataset[position])
        holder.itemView.rank_textview.text=(position+1).toString()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}


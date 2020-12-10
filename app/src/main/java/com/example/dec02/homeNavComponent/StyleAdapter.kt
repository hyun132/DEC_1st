package com.example.dec02.homeNavComponent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dec02.R
import com.example.dec02.StyleData
import kotlinx.android.synthetic.main.style_item.view.*

class StyleAdapter(private val myDataset: Array<StyleData>) :
    RecyclerView.Adapter<StyleAdapter.MyViewHolder>() {
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val style_thumbnail = itemView.style_thumbnail
        private val style_description = itemView.style_description
        private val style_title = itemView.style_title

        fun bind(item: StyleData) {
            style_description.text = item.style_name
            style_title.text = item.style_title
            Glide.with(itemView.rootView.context).load(item.style_thumbnail).into(style_thumbnail)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StyleAdapter.MyViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.style_item, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) { //item view와 data 연결
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.bind(myDataset[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}

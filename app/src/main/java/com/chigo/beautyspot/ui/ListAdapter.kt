package com.chigo.beautyspot.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chigo.beautyspot.R
import com.chigo.beautyspot.data.Details
import kotlinx.android.synthetic.main.activity_dummy.view.*
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter(var items: ArrayList<Details>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val current = items[position]

        holder.title_view.text = current.name
        holder.address.text  = current.address
        holder.rating.text = current.rating.toString()

        holder.ratingBar.numStars  = current.rating

        if(current.open){
            holder.openStatus.text = "Open"
        }else{
            holder.openStatus.text = "Close"
        }
    }

    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title_view = view.findViewById<TextView>(R.id.title_view)
        val address  = view.findViewById<TextView>(R.id.services_textView)
        val openStatus = view.findViewById<TextView>(R.id.open_status)
        val rating = view.findViewById<TextView>(R.id.ratings)
        val ratingBar = view.findViewById<RatingBar>(R.id.ratingBar)
    }


}
package com.enigmacamp.examplehandon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class LanguageRecyclerAdapter :  RecyclerView.Adapter<LanguageViewHolder>() {

    private var dataList =  ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.language_item_layout, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.orderNumber.text = position.toString()
        holder.languageName.text = dataList[position]
        holder.itemView.setOnClickListener{ holder }
    }

    fun setData(languageList: MutableList<String>) {
        dataList.clear()
        dataList.addAll(languageList)
        notifyDataSetChanged()
    }
}
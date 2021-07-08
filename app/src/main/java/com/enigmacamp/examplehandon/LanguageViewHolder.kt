package com.enigmacamp.examplehandon

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LanguageViewHolder(v: View): RecyclerView.ViewHolder(v) {

    val orderNumber: TextView = v.findViewById(R.id.order_number)
    val languageName: TextView = v.findViewById(R.id.language_name)

}
package com.example.poemapp

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PoemViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val showtitle : TextView  =view.findViewById(R.id.textTitle)
    val showPoem : TextView  =view.findViewById(R.id.textPoem)
    val layout : LinearLayout = view.findViewById(R.id.recordLayout)
    val DeleteBtn : ImageView = view.findViewById(R.id.deletebtn)
}

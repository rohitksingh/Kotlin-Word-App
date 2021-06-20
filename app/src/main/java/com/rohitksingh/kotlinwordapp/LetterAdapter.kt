package com.rohitksingh.kotlinwordapp

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityEvent
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    private val letterList = ('A').rangeTo('Z').toList()
    private val TAG = "LetterAdapter"


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_letter, parent, false)
        return LetterViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: "+letterList.size)
        holder.bind(letterList[position])
    }

    override fun getItemCount(): Int = letterList.size


    class LetterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var letterTextView : TextView = itemView.findViewById(R.id.letter)

        fun bind(letter: Char){
            letterTextView.text = letter.toString()
        }

    }

}
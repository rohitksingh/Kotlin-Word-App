package com.rohitksingh.kotlinwordapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rohitksingh.kotlinwordapp.databinding.ItemListLetterBinding

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    private val letterList = ('A').rangeTo('Z').toList()
    private val TAG = "LetterAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {

        val binding : ItemListLetterBinding = ItemListLetterBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return LetterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: "+letterList.size)
        holder.bind(letterList[position])
    }

    override fun getItemCount(): Int = letterList.size

    class LetterViewHolder(private val binding: ItemListLetterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(letter: Char){
            binding.letter.text = letter.toString()
        }
    }

}
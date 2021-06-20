package com.rohitksingh.kotlinwordapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rohitksingh.kotlinwordapp.databinding.ItemListLetterBinding

class LetterAdapter(val itemclickListener: ItemclickListener) : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    private val letterList = ('A').rangeTo('Z').toList()
    private val TAG = "LetterAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {

        val binding: ItemListLetterBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_list_letter, parent, false)
        return LetterViewHolder(binding, itemclickListener)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: " + letterList.size)
        holder.bind(letterList[position])
    }

    override fun getItemCount(): Int = letterList.size

    class LetterViewHolder(
            private var binding: ItemListLetterBinding,
            private var itemclickListener: ItemclickListener
            ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(letter: Char) {
            binding.setLetter(letter.toString())
            binding.itemclicklistner = itemclickListener
        }
    }

}
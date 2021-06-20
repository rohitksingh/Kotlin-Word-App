package com.rohitksingh.kotlinwordapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rohitksingh.kotlinwordapp.databinding.ItemWordLetterBinding

class WordListAdapter: RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private val wordList  = listOf("Hehe", "kajs", "asa")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {

        val binding = ItemWordLetterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(wordList[position])
    }

    override fun getItemCount() = wordList.size

    class WordViewHolder(private val binding: ItemWordLetterBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(word: String){
            binding.word.text = word
        }

    }

}


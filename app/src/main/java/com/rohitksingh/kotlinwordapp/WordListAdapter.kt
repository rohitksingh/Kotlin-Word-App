package com.rohitksingh.kotlinwordapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rohitksingh.kotlinwordapp.databinding.ItemWordLetterBinding

class WordListAdapter(context: Context, private val startingLetter: Char) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private val allWords: List<String> = context.resources.getStringArray(R.array.words).toList()
    private var filteredWords = allWords.filter { it.startsWith(startingLetter, ignoreCase = true) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {

        val binding = ItemWordLetterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(filteredWords[position])
    }

    override fun getItemCount() = filteredWords.size

    class WordViewHolder(private val binding: ItemWordLetterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(word: String) {
            binding.word.text = word
        }

    }

}


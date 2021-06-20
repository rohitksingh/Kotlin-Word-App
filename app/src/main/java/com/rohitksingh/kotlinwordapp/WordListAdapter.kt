package com.rohitksingh.kotlinwordapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rohitksingh.kotlinwordapp.databinding.ItemListWordBinding

class WordListAdapter(context: Context, private val startingLetter: Char) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private val allWords: List<String> = context.resources.getStringArray(R.array.words).toList()
    private var filteredWords = allWords.filter { it.startsWith(startingLetter, ignoreCase = true) }
    private val itemClickListener = context as ItemclickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {

        val binding: ItemListWordBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_list_word, parent, false)
        return WordViewHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(filteredWords[position])
    }

    override fun getItemCount() = filteredWords.size

    class WordViewHolder(private var binding: ItemListWordBinding,
                         private var itemClickListener: ItemclickListener) : RecyclerView.ViewHolder(binding.root) {

        fun bind(word: String) {
            binding.setWord(word)
            binding.itemclicklistener = itemClickListener
        }

    }

}


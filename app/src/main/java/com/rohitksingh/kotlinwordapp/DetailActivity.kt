package com.rohitksingh.kotlinwordapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rohitksingh.kotlinwordapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(), ItemclickListener {

    private lateinit var binding: ActivityDetailBinding
    private val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
    private lateinit var adapter: WordListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        receiveValue()?.let { initRecyclerView(it) }
    }

    override fun itemClicked(word: String) {
        searchWordInBrowser(Uri.parse(SEARCH_PREFIX + word))
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
    }

    private fun initRecyclerView(startingLetter: String) {
        adapter = WordListAdapter(this, startingLetter[0])
        binding.wordRecyclerView.layoutManager = layoutManager
        binding.wordRecyclerView.adapter = adapter
    }

    private fun receiveValue() = intent?.extras?.getString(MainActivity.LETTER_KEY)

    private fun searchWordInBrowser(url: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, url)
        startActivity(intent)
    }

    companion object {

        const val SEARCH_PREFIX = "https://www.google.com/search?q="

    }


}
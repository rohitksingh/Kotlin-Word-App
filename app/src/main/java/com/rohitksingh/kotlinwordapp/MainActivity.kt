package com.rohitksingh.kotlinwordapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rohitksingh.kotlinwordapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemclickListener {

    private val adapter: LetterAdapter = LetterAdapter(this)
    private val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        setupAdapter()
    }

    override fun itemClicked(letter: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(LETTER_KEY, letter)
        startActivity(intent)
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun setupAdapter() {
        binding.letterRecyclerView.adapter = adapter
        binding.letterRecyclerView.layoutManager = layoutManager
    }

    companion object {

        const val LETTER_KEY = "MainActivity.LETTER_KEY"

    }
}
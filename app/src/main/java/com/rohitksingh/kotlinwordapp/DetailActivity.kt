package com.rohitksingh.kotlinwordapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rohitksingh.kotlinwordapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
    private val adapter = WordListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        initRecyclerView()
    }

    private fun initBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
    }

    private fun initRecyclerView(){
        binding.wordRecyclerView.layoutManager = layoutManager
        binding.wordRecyclerView.adapter = adapter
    }

    private fun receiveValue(){
        val value = intent?.extras?.getString(MainActivity.LETTER_KEY)
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
    }

}
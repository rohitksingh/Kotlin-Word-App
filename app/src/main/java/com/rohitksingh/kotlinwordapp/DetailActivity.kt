package com.rohitksingh.kotlinwordapp

import android.os.Bundle
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

}
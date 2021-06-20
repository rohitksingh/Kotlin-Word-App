package com.rohitksingh.kotlinwordapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rohitksingh.kotlinwordapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , ItemclickListener{

    private val adapter : LetterAdapter = LetterAdapter(this)
    private val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        setupAdapter()
    }

    override fun itemClicked(word: String) {
        //Pass that value to Intent
    }

    private fun initBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun setupAdapter(){
        binding.letterRecyclerView.adapter = adapter
        binding.letterRecyclerView.layoutManager = layoutManager
    }
}
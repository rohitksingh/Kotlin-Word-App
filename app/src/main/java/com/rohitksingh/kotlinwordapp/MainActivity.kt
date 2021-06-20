package com.rohitksingh.kotlinwordapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var letterRecyclerView : RecyclerView
    private val adapter : LetterAdapter = LetterAdapter()
    private val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun setupAdapter(){
        letterRecyclerView = findViewById(R.id.letterRecyclerView)
        letterRecyclerView.adapter = adapter
        letterRecyclerView.layoutManager = layoutManager
    }
}
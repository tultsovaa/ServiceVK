package com.example.servicevk.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

import com.example.servicevk.MainAdapter
import com.example.servicevk.R
import com.example.servicevk.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var mainAdapter: MainAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv.findViewById<RecyclerView>(R.id.recycler)
        mainAdapter = MainAdapter()
        rv.adapter = mainAdapter
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getServices()
        viewModel.services.observe(this, Observer { list ->
           list.body()?.let { mainAdapter.setList(it) }
        })
    }
}


package com.example.servicevk.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
        rv = findViewById(R.id.recycler)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        rv.layoutManager = layoutManager
        mainAdapter = MainAdapter{position -> onListItemClick(position)}
        rv.adapter = mainAdapter
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getServices()
        viewModel.observeServiceLiveData().observe(this) { list ->
            mainAdapter.setList(list.body()!!.items)
        }

    }
    private fun onListItemClick(position: Int) {
        val intent = Intent(this, ServiceActivity::class.java)
        intent.putExtra("name", position)
        startActivity(intent)
    }
}


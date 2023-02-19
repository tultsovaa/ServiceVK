package com.example.servicevk.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.servicevk.R
import com.example.servicevk.viewmodel.MainViewModel

class ServiceActivity: AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        val arguments = intent.extras

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        var icon: ImageView = findViewById(R.id.icon)
        var name: TextView = findViewById(R.id.name)
        var description: TextView = findViewById(R.id.description)
        var url: TextView = findViewById(R.id.url)
        viewModel.observeServiceLiveData().observe(this, Observer { service ->
           service.body()?.items?.forEach { it ->
               if (it.name == arguments?.getString("name")) {
                   description.text = it.description
               }
           }
        })
    }
}
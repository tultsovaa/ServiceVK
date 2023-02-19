package com.example.servicevk.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.servicevk.R
import com.example.servicevk.model.ServiceModel
import com.example.servicevk.viewmodel.MainViewModel

class ServiceActivity: AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var service: ServiceModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        val arguments = intent.extras

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val icon: ImageView = findViewById(R.id.icon)
        val name: TextView = findViewById(R.id.name)
        val description: TextView = findViewById(R.id.description)
        val url: TextView = findViewById(R.id.url)

        viewModel.getServices()
        viewModel.services.observe(this) {
            service = viewModel.getService(arguments?.getInt("name")!!.toInt())
            title = service.name
            Glide.with(this).load(service.icon_url).into(icon)
            name.text = service.name
            description.text = service.description
            url.text = service.service_url
        }
    }
}
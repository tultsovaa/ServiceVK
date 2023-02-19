package com.example.servicevk.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api : API by lazy {
        Retrofit.Builder()
            .baseUrl("https://mobile-olympiad-trajectory.hb.bizmrg.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }
}
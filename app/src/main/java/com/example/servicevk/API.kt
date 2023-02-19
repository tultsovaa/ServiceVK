package com.example.servicevk

import android.os.Handler

import com.example.servicevk.model.ServiceModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET
    fun getServiceInfo() : Call<ServiceModel>
}
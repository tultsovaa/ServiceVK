package com.example.servicevk.data

import com.example.servicevk.ServiceListResponse
import com.example.servicevk.ServiceModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {

    @GET("semi-final-data.json")
    suspend fun getServiceInfo() : Response<ServiceListResponse>

}
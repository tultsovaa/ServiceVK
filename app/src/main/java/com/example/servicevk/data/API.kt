package com.example.servicevk.data

import com.example.servicevk.model.ServiceListResponse
import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("semi-final-data.json")
    suspend fun getServiceInfo() : Response<ServiceListResponse>

}
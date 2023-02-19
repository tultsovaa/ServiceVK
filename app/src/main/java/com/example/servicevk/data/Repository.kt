package com.example.servicevk.data

import com.example.servicevk.ServiceListResponse
import com.example.servicevk.ServiceModel
import retrofit2.Response

class Repository {
    suspend fun getServiceInfo(): Response<ServiceListResponse> {
        return RetrofitInstance.api.getServiceInfo()
    }
}
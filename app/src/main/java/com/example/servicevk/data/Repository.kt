package com.example.servicevk.data

import com.example.servicevk.model.ServiceListResponse
import retrofit2.Response


class Repository {
    suspend fun getServiceInfo(): Response<ServiceListResponse> {
        return RetrofitInstance.api.getServiceInfo()
    }
}

package com.example.servicevk.data

import android.R.id
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.servicevk.ServiceListResponse
import com.example.servicevk.ServiceModel
import retrofit2.Response


class Repository {
    suspend fun getServiceInfo(): Response<ServiceListResponse> {
        return RetrofitInstance.api.getServiceInfo()
    }


}

package com.example.servicevk.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.servicevk.ServiceListResponse
import com.example.servicevk.data.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {
    val services: MutableLiveData<Response<ServiceListResponse>> = MutableLiveData()
    val repo = Repository()

    fun getServices() {
        viewModelScope.launch {
            services.value = repo.getServiceInfo()
        }
    }

}
package com.example.servicevk.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.servicevk.model.ServiceListResponse
import com.example.servicevk.model.ServiceModel
import com.example.servicevk.data.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {
    val services: MutableLiveData<Response<ServiceListResponse>> = MutableLiveData()
    private var serviceList = listOf<ServiceModel>()
    private val repo = Repository()

    fun getServices() {
        viewModelScope.launch {
            services.value = repo.getServiceInfo()
            serviceList = services.value!!.body()?.items!!
            }
        }

    fun getService(position: Int): ServiceModel {
        return services.value!!.body()?.items!![position]
    }

    fun observeServiceLiveData() : MutableLiveData<Response<ServiceListResponse>> {
        return services
    }

}
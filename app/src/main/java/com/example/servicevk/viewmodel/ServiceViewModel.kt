package com.example.servicevk.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.servicevk.RetrofitInstance
import com.example.servicevk.model.ServiceModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceViewModel : ViewModel() {
    private var serviceLiveData = MutableLiveData<List<ServiceModel>>()
    fun getServiceInfo() {
        RetrofitInstance.api.getServiceInfo()
    }
    fun observeServiceLiveData() : LiveData<List<ServiceModel>> {
        return serviceLiveData
    }
}
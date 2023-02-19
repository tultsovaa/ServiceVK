package com.example.servicevk.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.servicevk.data.RetrofitInstance
import com.example.servicevk.ServiceModel
import com.example.servicevk.data.Repository
import retrofit2.Response

class ServiceViewModel : ViewModel() {
    val repo = Repository()

}
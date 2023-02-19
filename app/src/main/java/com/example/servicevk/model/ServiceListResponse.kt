package com.example.servicevk.model

data class ServiceListResponse(
    val items: List<ServiceModel>
)

data class ServiceModel(
    var name: String,
    var description: String,
    var icon_url: String,
    var service_url: String
)
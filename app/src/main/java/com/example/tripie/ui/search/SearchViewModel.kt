package com.example.tripie.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tripie.common.ServiceType
import com.example.tripie.data.mock.MockData
import com.example.tripie.data.mock.MostPopularHotel

class SearchViewModel : ViewModel() {
    private val _selectedService: MutableLiveData<ServiceType> = MutableLiveData(ServiceType.HOTEL)
    val selectedService: LiveData<ServiceType> get() = _selectedService

    private val _mostPopularHotel: MutableLiveData<MostPopularHotel> = MutableLiveData()
    val mostPopularHotel: LiveData<MostPopularHotel> get() = _mostPopularHotel

    fun changeSelectedService(serviceType: ServiceType) {
        _selectedService.value = serviceType
    }

    fun getMostPopularHotel() {
        _mostPopularHotel.value = MockData.mostPopularHotel
    }
}
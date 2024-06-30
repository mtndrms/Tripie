package com.example.tripie.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tripie.common.ServiceType
import com.example.tripie.data.mock.MockBusData
import com.example.tripie.data.mock.MockHotelData
import com.example.tripie.data.mock.MockPlaneData
import com.example.tripie.data.mock.response.ResponseBestDeal
import com.example.tripie.data.mock.response.ResponseMostPopularHotel
import com.example.tripie.data.model.Flight
import com.example.tripie.data.model.Trip
import kotlinx.coroutines.flow.MutableStateFlow

class SearchViewModel : ViewModel() {
    private val _selectedService: MutableLiveData<ServiceType> = MutableLiveData(ServiceType.HOTEL)
    val selectedService: LiveData<ServiceType> get() = _selectedService

    private val _mostPopularHotel: MutableLiveData<ResponseMostPopularHotel> = MutableLiveData()
    val mostPopularHotel: LiveData<ResponseMostPopularHotel> get() = _mostPopularHotel

    private val _bestDeal: MutableLiveData<ResponseBestDeal> = MutableLiveData()
    val bestDeal: LiveData<ResponseBestDeal> get() = _bestDeal

    private val _upcomingFlight: MutableLiveData<Flight> = MutableLiveData()
    val upcomingFlight: LiveData<Flight> get() = _upcomingFlight

    private val _upcomingBusTrip: MutableLiveData<Trip> = MutableLiveData()
    val upcomingBusTrip: LiveData<Trip> get() = _upcomingBusTrip

    fun changeSelectedService(serviceType: ServiceType) {
        _selectedService.value = serviceType
    }

    fun getMostPopularHotel() {
        _mostPopularHotel.value = MockHotelData.mostPopularHotel
    }

    fun getUpcomingFlight() {
        _upcomingFlight.value = MockPlaneData.upcomingFlight
    }

    fun getBestFlightDeal() {
        _bestDeal.value = MockPlaneData.bestDeal
    }

    fun getUpcomingBusTrip() {
        _upcomingBusTrip.value = MockBusData.upcomingBusTrip
    }
}
package com.example.tripie.ui.search.bus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tripie.R
import com.example.tripie.databinding.FragmentBusBinding
import com.example.tripie.ui.search.SearchViewModel

class BusFragment : Fragment() {

    private lateinit var binding: FragmentBusBinding
    private val viewModel: SearchViewModel by viewModels(ownerProducer = { requireParentFragment() })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getUpcomingBusTrip()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBusBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        upcomingBusTrip()
    }

    private fun upcomingBusTrip() {
        viewModel.upcomingBusTrip.observe(viewLifecycleOwner) { trip ->
            binding.run {
                tvDepartureTime.text = trip.departureTime
                tvDepartureLocation.text = trip.from
                tvDepartureDate.text = getString(
                    R.string.flight_departure_and_arrival_date,
                    trip.departureDate,
                    trip.departureTime
                )
                tvArrivalTime.text = trip.arrivalTime
                tvDestination.text = trip.to
                tvArrivalDate.text = getString(
                    R.string.flight_departure_and_arrival_date,
                    trip.departureDate,
                    trip.departureTime
                )
                tvTripTime.text = getString(R.string.flight_time, trip.tripLengthInHours)
            }
        }
    }

    companion object {
        fun newInstance() = BusFragment()
    }
}
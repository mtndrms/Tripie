package com.example.tripie.ui.search.plane

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tripie.R
import com.example.tripie.databinding.FragmentPlaneBinding
import com.example.tripie.ui.search.SearchViewModel

class PlaneFragment : Fragment() {

    private lateinit var binding: FragmentPlaneBinding
    private val viewModel: SearchViewModel by viewModels(ownerProducer = { requireParentFragment() })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.run {
            getBestFlightDeal()
            getUpcomingFlight()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaneBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        upcomingFlight()
        bestDeal()
    }

    private fun upcomingFlight() {
        viewModel.upcomingFlight.observe(viewLifecycleOwner) { flight ->
            binding.run {
                tvDepartureTime.text = flight.departureTime
                tvDepartureLocation.text = flight.departureCity
                tvDepartureDate.text = getString(
                    R.string.flight_departure_and_arrival_date,
                    flight.departureDate,
                    flight.departureTime
                )
                tvArrivalTime.text = flight.arrivalTime
                tvDestination.text = flight.arrivalCity
                tvArrivalDate.text = getString(
                    R.string.flight_departure_and_arrival_date,
                    flight.departureDate,
                    flight.departureTime
                )
                tvFlightTime.text = getString(R.string.flight_time, flight.flightTimeHours)
            }
        }
    }

    private fun bestDeal() {
        viewModel.bestDeal.observe(viewLifecycleOwner) { bestDeal ->
            binding.run {
                tvPlace.text = getString(
                    R.string.flight_arrival_location,
                    bestDeal.flight.arrivalCity,
                    bestDeal.flight.arrivalCountry
                )
                tvAirline.text = bestDeal.airline
                tvBestDealFlightDate.text = getString(
                    R.string.best_deal_flight_date,
                    bestDeal.flight.departureDate,
                    bestDeal.flight.departureTime
                )
                tvPrice.text = getString(R.string.price_per_passenger, bestDeal.price)
            }
        }
    }

    companion object {
        fun newInstance() = PlaneFragment()
    }
}
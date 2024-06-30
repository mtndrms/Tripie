package com.example.tripie.ui.search.hotel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.tripie.R
import com.example.tripie.databinding.FragmentHotelBinding
import com.example.tripie.databinding.FragmentSearchBinding
import com.example.tripie.ui.search.SearchViewModel

class HotelFragment : Fragment() {

    private lateinit var binding: FragmentHotelBinding
    private val viewModel: SearchViewModel by viewModels(ownerProducer = { requireParentFragment() })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getMostPopularHotel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHotelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.mostPopularHotel.observe(viewLifecycleOwner) { response ->
            binding.run {
                tvHotelName.text = response.hotel.name
                tvMostPopularHotelLocation.text =
                    getString(
                        R.string.hotel_location,
                        response.hotel.city,
                        response.hotel.country
                    )
                tvHotelInfo.text = getString(
                    R.string.most_popular_hotel_date_info,
                    response.nights,
                    response.startDate,
                    response.endDate
                )
                tvPrice.text = getString(
                    R.string.price_per_night,
                    response.hotel.pricePerNight
                )
                tvRating.text = getString(
                    R.string.reviews,
                    response.hotel.rating,
                    response.hotel.reviews.size
                )
            }
        }
    }

    companion object {
        fun newInstance() = HotelFragment()
    }
}
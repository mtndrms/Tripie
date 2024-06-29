package com.example.tripie.ui.search

import android.content.res.ColorStateList
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.TextViewCompat
import com.example.tripie.R
import com.example.tripie.common.ServiceType
import com.example.tripie.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    companion object {
        fun newInstance() = SearchFragment()
    }

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getMostPopularHotel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chips = listOf(
            binding.serviceHotel,
            binding.servicePlane,
            binding.serviceCar,
            binding.serviceBoat
        )

        chips.forEach { chip ->
            chip.setOnClickListener {
                chips.toMutableList().remove(chip)
                changeChipStyleDefault(chips)
                onServiceChipClicked(chip)
            }
        }

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

    private fun onServiceChipClicked(tvServiceType: TextView) {
        when (tvServiceType) {
            binding.serviceHotel -> {
                viewModel.changeSelectedService(ServiceType.HOTEL)
            }

            binding.servicePlane -> {
                viewModel.changeSelectedService(ServiceType.PLANE)
            }

            binding.serviceCar -> {
                viewModel.changeSelectedService(ServiceType.CAR)
            }

            binding.serviceBoat -> {
                viewModel.changeSelectedService(ServiceType.BOAT)
            }
        }

        changeChipStyleSelected(tvServiceType)
    }

    private fun changeChipStyleDefault(chips: List<TextView>) {
        chips.forEach { chip ->
            val theme = context?.theme
            val color = ResourcesCompat.getColor(resources, R.color.black, theme)

            chip.background = ResourcesCompat.getDrawable(
                resources,
                R.drawable.bg_type_chip,
                context?.theme
            )
            chip.setTextColor(color)
            TextViewCompat.setCompoundDrawableTintList(
                chip,
                ColorStateList.valueOf(color)
            )
        }
    }

    private fun changeChipStyleSelected(tvSelected: TextView) {
        val theme = context?.theme
        val color = ResourcesCompat.getColor(resources, R.color.white, theme)

        tvSelected.background = ResourcesCompat.getDrawable(
            resources,
            R.drawable.bg_type_chip_selected,
            context?.theme
        )
        tvSelected.setTextColor(color)
        TextViewCompat.setCompoundDrawableTintList(
            tvSelected,
            ColorStateList.valueOf(color)
        )
    }
}
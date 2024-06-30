package com.example.tripie.ui.search

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tripie.R
import com.example.tripie.common.ServiceType
import com.example.tripie.databinding.FragmentSearchBinding
import com.example.tripie.ui.search.boat.BoatFragment
import com.example.tripie.ui.search.bus.BusFragment
import com.example.tripie.ui.search.car.CarFragment
import com.example.tripie.ui.search.hotel.HotelFragment
import com.example.tripie.ui.search.plane.PlaneFragment
import java.util.EnumMap

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModels()
    private val chips: EnumMap<ServiceType, TextView> = EnumMap(ServiceType::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        chips[ServiceType.HOTEL] = binding.serviceHotel
        chips[ServiceType.PLANE] = binding.servicePlane
        chips[ServiceType.BUS] = binding.serviceBus
        chips[ServiceType.CAR] = binding.serviceCar
        chips[ServiceType.BOAT] = binding.serviceBoat

        setupServiceChips()
        displayRelatedServiceFragment()
    }

    private fun displayRelatedServiceFragment() {
        viewModel.selectedService.observe(viewLifecycleOwner) { serviceType ->
            when (serviceType) {
                ServiceType.HOTEL -> changeFragment(HotelFragment.newInstance())
                ServiceType.PLANE -> changeFragment(PlaneFragment.newInstance())
                ServiceType.BUS -> changeFragment(BusFragment.newInstance())
                ServiceType.CAR -> changeFragment(CarFragment.newInstance())
                ServiceType.BOAT -> changeFragment(BoatFragment.newInstance())
                else -> changeFragment(HotelFragment.newInstance())
            }

            changeChipStyleSelected(serviceType)
        }
    }

    private fun setupServiceChips() {
        chips.forEach { (key, value) ->
            value.setOnClickListener {
                onServiceChipClicked(key)
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        childFragmentManager
            .beginTransaction()
            .replace(R.id.fcvServiceType, fragment)
            .commit()
    }

    private fun onServiceChipClicked(serviceType: ServiceType) {
        viewModel.changeSelectedService(serviceType)
        changeChipStyleDefault(serviceType)
        changeChipStyleSelected(serviceType)
    }

    private fun changeChipStyleDefault(serviceType: ServiceType) {
        this.chips.filterKeys { it != serviceType }.forEach { (_, chip) ->
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

    private fun changeChipStyleSelected(serviceType: ServiceType) {
        val theme = context?.theme
        val color = ResourcesCompat.getColor(resources, R.color.white, theme)

        chips[serviceType]?.let { chip ->
            chip.background = ResourcesCompat.getDrawable(
                resources,
                R.drawable.bg_type_chip_selected,
                context?.theme
            )
            chip.setTextColor(color)
            TextViewCompat.setCompoundDrawableTintList(
                chip,
                ColorStateList.valueOf(color)
            )
        }
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}
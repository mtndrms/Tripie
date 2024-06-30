package com.example.tripie.ui.search.car

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.tripie.R
import com.example.tripie.databinding.FragmentCarBinding
import com.example.tripie.ui.search.SearchViewModel

class CarFragment : Fragment() {

    private lateinit var binding: FragmentCarBinding
    private val viewModel: SearchViewModel by viewModels(ownerProducer = { requireParentFragment() })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = CarFragment()
    }
}
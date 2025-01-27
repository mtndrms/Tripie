package com.example.tripie

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tripie.databinding.ActivityMainBinding
import com.example.tripie.ui.home.HomeFragment
import com.example.tripie.ui.profile.ProfileFragment
import com.example.tripie.ui.search.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupInitialFragment(savedInstanceState)
        setupWindowInsets()
        setupBottomNavigationView()
    }

    private fun setupWindowInsets() {
        // If 3-button navigation is being used it's background color not gonna effected
        // otherwise the system navigation bar background will be transparent
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
    }

    private fun setupInitialFragment(savedInstanceState: Bundle?) {
        // Add the initial fragment only if the activity is not being recreated
        if (savedInstanceState == null) {
            // Initial fragment
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fcvAppHost, SearchFragment.newInstance())
                .commit()
        }
    }

    private fun setupBottomNavigationView() {
        // Top level destinations for bottom navigation view
        binding.bnvBottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val fragment = HomeFragment.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvAppHost, fragment)
                        .addToBackStack("HomeFragment")
                        .commit()

                    true
                }

                R.id.search -> {
                    val fragment = SearchFragment.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvAppHost, fragment)
                        .addToBackStack("SearchFragment")
                        .commit()

                    true
                }

                R.id.profile -> {
                    val fragment = ProfileFragment.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvAppHost, fragment)
                        .addToBackStack("ProfileFragment")
                        .commit()

                    true
                }

                else -> false
            }
        }
    }
}
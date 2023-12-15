package com.example.noxosrefactory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.example.noxosrefactory.databinding.ActivityBottomNavigationBinding
import com.example.noxosrefactory.view.fragments.HomeFragment
import com.example.noxosrefactory.view.fragments.OrderFragment
import com.example.noxosrefactory.view.fragments.ProductionFragment
import com.example.noxosrefactory.view.fragments.SearchFragment

class BottomNavigation : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.navView.setOnClickListener {
            when (it.id) {
                R.id.ic_home -> replaceFragment(HomeFragment())
                R.id.ic_search -> replaceFragment(SearchFragment())
                R.id.ic_order -> replaceFragment(OrderFragment())
                R.id.ic_production -> replaceFragment(ProductionFragment())
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fl_wrapper, fragment)
                commit()
            }

}
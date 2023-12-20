package com.example.noxosrefactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import com.example.noxosrefactory.databinding.ActivityMainBinding
import com.example.noxosrefactory.service.model.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
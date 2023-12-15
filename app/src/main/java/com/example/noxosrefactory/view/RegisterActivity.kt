package com.example.noxosrefactory.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noxosrefactory.R
import com.example.noxosrefactory.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
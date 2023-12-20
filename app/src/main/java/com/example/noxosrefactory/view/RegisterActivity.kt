package com.example.noxosrefactory.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.noxosrefactory.R
import com.example.noxosrefactory.databinding.ActivityRegisterBinding
import com.example.noxosrefactory.viewModel.LoginViewModel
import com.example.noxosrefactory.viewModel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
private lateinit var viewModel:RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        setContentView(binding.root)

        binding.txtLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }


    }}
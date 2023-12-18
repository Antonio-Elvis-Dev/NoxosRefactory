package com.example.noxosrefactory.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.noxosrefactory.MainActivity
import com.example.noxosrefactory.R

import com.example.noxosrefactory.databinding.ActivityLoginBinding
import com.example.noxosrefactory.service.model.PersonModel

import com.example.noxosrefactory.viewModel.LoginViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)
        binding.txtRegister.setOnClickListener(this)

        observe()
    }


    override fun onClick(v: View) {
        if (v.id == R.id.btnLogin) {
            handleLogin()
        }
    }

    private fun observe() {
        viewModel.login
            .observe(this
            ) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }

        viewModel.failure
            .observe(this
            ) {
               Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
            }

    }


    private fun handleLogin() {
        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()


        viewModel.doLogin(email, password)
    }
}
package com.proyecto.proyectofinalmoviles.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.proyecto.proyectofinalmoviles.data.model.User
import com.proyecto.proyectofinalmoviles.data.viewModel.UserViewModel
import com.proyecto.proyectofinalmoviles.databinding.ActivityMainBinding


import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]


        binding.Exit.setOnClickListener {
            finish()
            exitProcess(0)
        }

        binding.logInBtn.setOnClickListener {
            loginValidation(binding.editTextUserName.text.toString(),binding.editTextTextPassword.text.toString())
        }
    }

    private fun loginValidation(username:String,password:String){
        if(username.isEmpty()||password.isEmpty()){
            Toast.makeText(applicationContext,"No dejes campos vacios",Toast.LENGTH_SHORT).show()
        } else{

            val user: User = userViewModel.validate(username,password)



            if (user==null){
                Toast.makeText(applicationContext,"Credenciales Invalidas",Toast.LENGTH_SHORT).show()
            }else{
                roleValidation(user)
            }


        }

    }

    private fun roleValidation(user:User){
        if(user.roleId == 1){
            Toast.makeText(applicationContext,"Welcome Admin",Toast.LENGTH_SHORT).show()

        }
    }
}
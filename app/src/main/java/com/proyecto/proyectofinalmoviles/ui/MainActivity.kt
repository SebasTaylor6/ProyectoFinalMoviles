package com.proyecto.proyectofinalmoviles.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.proyecto.proyectofinalmoviles.data.model.User
import com.proyecto.proyectofinalmoviles.data.viewModel.LoginViewModel
import com.proyecto.proyectofinalmoviles.databinding.ActivityMainBinding


import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginViewModel: LoginViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this)[loginViewModel::class.java]


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

            val user: User = loginViewModel.validate(username,password)

            if (user==null){
                Toast.makeText(applicationContext,"Credenciales Invalidas",Toast.LENGTH_SHORT).show()
            }else{
                roleValidation(user)
            }


        }

    }

    private fun roleValidation(user:User){
        when(user.roleId){
            1->{
                adminView(user)
            }
            2->{
                clientView(user)

            }
            else->{
                Toast.makeText(applicationContext,"No Role Set",Toast.LENGTH_SHORT).show()

            }
        }

    }

    private fun adminView(user:User){
        val intent:Intent = Intent(this,AdminActivity::class.java)
        val bundle:Bundle =Bundle()
        user.id?.let { bundle.putInt("id", it) }
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun clientView(user:User){
        val intent:Intent = Intent(this,ClientActivity::class.java)
        val bundle:Bundle =Bundle()
        user.id?.let { bundle.putInt("id", it) }
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
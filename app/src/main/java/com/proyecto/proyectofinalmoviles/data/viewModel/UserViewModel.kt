package com.proyecto.proyectofinalmoviles.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.proyecto.proyectofinalmoviles.data.database.MainDatabase
import com.proyecto.proyectofinalmoviles.data.model.User
import com.proyecto.proyectofinalmoviles.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val repository:UserRepository

    init {
        val userDao = MainDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(User(null,"admin","admin",1))
        }
    }

    fun validate(username: String, password: String): User {

        return repository.validate(username, password)
    }
}
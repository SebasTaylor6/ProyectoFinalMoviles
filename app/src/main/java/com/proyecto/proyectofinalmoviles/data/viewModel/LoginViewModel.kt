package com.proyecto.proyectofinalmoviles.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.proyecto.proyectofinalmoviles.data.database.MainDatabase
import com.proyecto.proyectofinalmoviles.data.model.Client
import com.proyecto.proyectofinalmoviles.data.model.User
import com.proyecto.proyectofinalmoviles.data.repository.ClientRepository
import com.proyecto.proyectofinalmoviles.data.repository.LoanRepository
import com.proyecto.proyectofinalmoviles.data.repository.SavingRepository
import com.proyecto.proyectofinalmoviles.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class LoginViewModel(application: Application):AndroidViewModel(application) {
    private val userRepository:UserRepository
    private val loanRepository:LoanRepository
    private val savingRepository:SavingRepository
    private val clientRepository:ClientRepository

    init {
        userRepository = UserRepository(MainDatabase.getDatabase(application).userDao())
        clientRepository = ClientRepository(MainDatabase.getDatabase(application).clientDao())
        loanRepository = LoanRepository(MainDatabase.getDatabase(application).loanDao())
        savingRepository = SavingRepository(MainDatabase.getDatabase(application).SavingDao())

        viewModelScope.launch(Dispatchers.IO){
            userRepository.addUser(User(null,"admin","admin",1))
        }

        insertClient(
            User(3,"client","client",2),
            Client(3,"123456789","Alonso",23.04,"121212", Date(2001,2,3),"taken",3)
        )
    }

    fun insertClient(user:User,client:Client){
        viewModelScope.launch(Dispatchers.IO){
            userRepository.addUser(user)
            clientRepository.addClient(client)
        }
    }

    fun validate(username: String, password: String): User {

        return userRepository.validate(username, password)
    }
}
package com.proyecto.proyectofinalmoviles.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.proyecto.proyectofinalmoviles.data.database.MainDatabase
import com.proyecto.proyectofinalmoviles.data.repository.ClientRepository
import com.proyecto.proyectofinalmoviles.data.repository.LoanRepository
import com.proyecto.proyectofinalmoviles.data.repository.SavingRepository
import com.proyecto.proyectofinalmoviles.data.repository.UserRepository

class AdminViewModel(application: Application): AndroidViewModel(application) {
    private val userRepository: UserRepository
    private val loanRepository: LoanRepository
    private val savingRepository: SavingRepository
    private val clientRepository: ClientRepository

    init {
        userRepository = UserRepository(MainDatabase.getDatabase(application).userDao())
        clientRepository = ClientRepository(MainDatabase.getDatabase(application).clientDao())
        loanRepository = LoanRepository(MainDatabase.getDatabase(application).loanDao())
        savingRepository = SavingRepository(MainDatabase.getDatabase(application).SavingDao())

    }

}
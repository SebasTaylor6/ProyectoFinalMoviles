package com.proyecto.proyectofinalmoviles.data.repository

import androidx.lifecycle.LiveData
import com.proyecto.proyectofinalmoviles.data.dao.ClientDao
import com.proyecto.proyectofinalmoviles.data.dao.UserDao
import com.proyecto.proyectofinalmoviles.data.model.Client
import com.proyecto.proyectofinalmoviles.data.model.User


class ClientRepository(private val clientDAO: ClientDao) {
    val readAllData:List<Client> = clientDAO.getAll()

    suspend fun addClient(client:Client){
        return clientDAO.insert(client)
    }

    suspend fun deleteClient(client:Client){
        return clientDAO.delete(client)
    }




}
package com.proyecto.proyectofinalmoviles.data.repository

import androidx.lifecycle.LiveData
import com.proyecto.proyectofinalmoviles.data.dao.UserDao
import com.proyecto.proyectofinalmoviles.data.model.User


class UserRepository(private val userDAO: UserDao) {
    val readAllData:List<User> = userDAO.getAll()

    suspend fun addUser(user:User){
        return userDAO.insert(user)
    }

    fun validate(username:String,password:String):User{
        return userDAO.validateLogin(username,password)
    }


}
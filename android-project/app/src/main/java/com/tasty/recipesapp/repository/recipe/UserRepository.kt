package com.tasty.recipesapp.repository.recipe

import android.content.Context
import android.os.UserManager
import com.google.gson.Gson
import com.tasty.recipesapp.repository.recipe.dao.RecipeDao
import com.tasty.recipesapp.repository.recipe.dao.UserDao
import com.tasty.recipesapp.repository.recipe.dtos.RecipeDTO
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.repository.recipe.models.UserModel
import org.json.JSONObject

class UserRepository(private val userDao: UserDao) {

    private var userList: List<UserModel> = emptyList()

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun getAllUsers(): List<UserModel> {
        userList = userDao.getAllUsers().map { userEntity ->
            UserModel(
                userId = userEntity.id.toString(), // Az ID-t szöveggé alakítjuk
                username = userEntity.name,
                password = userEntity.password
            )
        }
        return userList
    }

    suspend fun logInUser(name:String, password:String):Long{
        val userId= userDao.logInUser(name, password)
        return userId
    }
}
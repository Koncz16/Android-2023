package com.tasty.recipesapp.repository.recipe

import android.content.Context
import com.tasty.recipesapp.database.RecipeDatabase
import com.tasty.recipesapp.database.UserDatabase
import com.tasty.recipesapp.repository.recipe.dao.RecipeDao
import com.tasty.recipesapp.repository.recipe.dao.UserDao

object UserRepositoryProvider {
    private lateinit var userDao: UserDao

    fun initialize(context: Context) {
        userDao = UserDatabase.getDatabase(context).userDao()
    }

    val userRepository: UserRepository by lazy {
        checkInitialized()
        UserRepository(userDao)
    }

    private fun checkInitialized() {
        if (!::userDao.isInitialized) {
            throw UninitializedPropertyAccessException("UserRepositoryProvider has not been initialized")
        }
    }
}
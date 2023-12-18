package com.tasty.recipesapp.ui.recipe.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.RepositoryProvider
import com.tasty.recipesapp.repository.recipe.UserEntity
import com.tasty.recipesapp.repository.recipe.UserRepository
import com.tasty.recipesapp.repository.recipe.UserRepositoryProvider
import com.tasty.recipesapp.repository.recipe.models.UserModel
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val repository: UserRepository = UserRepositoryProvider.userRepository

    fun insertUser(user : UserEntity) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }
}
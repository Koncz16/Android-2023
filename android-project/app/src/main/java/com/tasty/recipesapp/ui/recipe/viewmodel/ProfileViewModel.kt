package com.tasty.recipesapp.ui.recipe.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.repository.recipe.RecipeEntity
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import kotlinx.coroutines.launch
import android.content.Context

class ProfileViewModel(context: Context) : ViewModel() {
    val repository = RecipeRepository(context)

    // LiveData to hold the list of recipes
    val allRecipes = repository.getMyRecipes()

    // Function to insert a recipe
    fun insertRecipe(recipe: RecipeEntity) {
        viewModelScope.launch {
            repository.insertRecipe(recipe)
        }
    }

    // Function to remove a recipe
    fun removeRecipe(recipe: RecipeEntity) {
        viewModelScope.launch {
            repository.deleteRecipe(recipe)
        }
    }
}
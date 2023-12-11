package com.tasty.recipesapp.ui.recipe.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.repository.recipe.Recipe
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import kotlinx.coroutines.launch
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tasty.recipesapp.repository.recipe.RecipeEntity
import com.tasty.recipesapp.repository.recipe.RepositoryProvider
import com.tasty.recipesapp.repository.recipe.mapper.InstructionMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.models.RecipeModel

class ProfileViewModel : ViewModel() {

    companion object {
        val TAG: String? = ProfileViewModel::class.java.canonicalName
    }

    private val repository: RecipeRepository = RepositoryProvider.recipeRepository
    val liveData = MutableLiveData<Array<RecipeModel>>()
    // LiveData to hold the list of recipes
    fun deleteRecipeById(recipeID: Int){
        viewModelScope.launch {
            repository.deleteRecipeById(recipeID)
        }
    }

    suspend fun getRecipeById(recipeId: Int): RecipeModel? {
        return repository.getRecipeById(recipeId)
    }

    fun insertRecipe(recipe: RecipeEntity) {
        viewModelScope.launch {
            repository.insertRecipe(recipe)
        }
    }

    fun getAllRecipes() {
        viewModelScope.launch {
            val list = repository.getAllRecipes()

            liveData.value = list.toTypedArray()
        }
    }

}

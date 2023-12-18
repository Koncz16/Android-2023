package com.tasty.recipesapp.ui.recipe.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.RepositoryProvider
import com.tasty.recipesapp.repository.recipe.dtos.RecipeDTO
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import kotlinx.coroutines.launch

class RecipeDetailViewModel :ViewModel(){

    companion object {
        val TAG: String? = RecipeDetailViewModel::class.java.canonicalName
    }


    var recipe:MutableLiveData<RecipeModel?> = MutableLiveData()
    private val recipeRepository = RepositoryProvider.recipeRepository

    fun fetchRecipeDetail(recipeId:Int, context: Context): RecipeModel? {
        val recipe = recipeRepository.getRecipe(context, recipeId)

        //this.recipe.value = recipe
        Log.d(TAG,"Recipe: ${recipe?.id} ::: ${   recipe?.name}")

        return recipe
    }
    fun getRecipeDetail(recipeId: Int) {
        viewModelScope.launch {
            val result = recipeRepository.getRecipeById(recipeId)
            Log.d(TAG,"Result name: ${result?.name}")
            recipe.value = result

        }
    }
    fun getRecipeDetailFromApi(recipeId: Int) {
        viewModelScope.launch {
            val result = recipeRepository.getRecipeByIdFromApi(recipeId.toString())
            Log.d(TAG, "Result name: ${result?.name}")
            recipe.value = result
        }
    }

}
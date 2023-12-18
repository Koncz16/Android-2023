package com.tasty.recipesapp.ui.recipe.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.RepositoryProvider
import com.tasty.recipesapp.repository.recipe.RepositoryProvider.recipeRepository
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecipeListViewModel: ViewModel() {
    val liveData = MutableLiveData<List<RecipeModel>>()

    fun loadInstructionData(context: Context){
        viewModelScope.launch {
            val list = recipeRepository.readRecipes(context)

            liveData.value = list
        }
    }

    fun getAllRecipesFromApi() {
        viewModelScope.launch {
//            val recipes = RepositoryProvider.recipeRepository.getRecipesFromApi("0", "15")
//            recipes.forEach {
//                Log.d("RECIPE_API", it.toString())
//            }

            val recipes = withContext(Dispatchers.IO){
                recipeRepository.getRecipesFromApi("0","50")
            }
            liveData.value=recipes
        }
    }


}
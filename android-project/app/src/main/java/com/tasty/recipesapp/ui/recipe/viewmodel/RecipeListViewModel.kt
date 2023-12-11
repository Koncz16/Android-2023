package com.tasty.recipesapp.ui.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.RepositoryProvider.recipeRepository
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import kotlinx.coroutines.launch

class RecipeListViewModel: ViewModel() {
    val liveData = MutableLiveData<Array<RecipeModel>>()

    fun loadInstructionData(context: Context){
        viewModelScope.launch {
            val list = recipeRepository.readRecipes(context)

            liveData.value = list.toTypedArray()
        }
    }
}
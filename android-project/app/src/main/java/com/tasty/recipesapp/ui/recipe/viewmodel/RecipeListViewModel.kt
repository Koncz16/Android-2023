package com.tasty.recipesapp.ui.recipe.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.ui.recipe.RecipesFragment
import kotlinx.coroutines.launch

class RecipeListViewModel: ViewModel() {
    val liveData = MutableLiveData<Array<RecipeModel>>()

    fun loadInstructionData(context: RecipesFragment){
        viewModelScope.launch {
            val list = RecipeRepository(context).readRecipes()
            val models = list.toModelList()
            liveData.value = models.toTypedArray()
        }
    }
}
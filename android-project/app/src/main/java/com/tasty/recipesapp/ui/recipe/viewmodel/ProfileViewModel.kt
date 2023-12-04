package com.tasty.recipesapp.ui.recipe.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.repository.recipe.RecipeEntity
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import kotlinx.coroutines.launch
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.ui.profile.ProfileFragment

class ProfileViewModel(context: Context) : ViewModel() {

    companion object {
        val TAG: String? = ProfileViewModel::class.java.canonicalName
    }

    val liveData : MutableLiveData<List<RecipeEntity>>
    = MutableLiveData() // Most List típust használunk
    val repository = RecipeRepository(context)

    // LiveData to hold the list of recipes
    fun allRecipes() {
        viewModelScope.launch {
            val list = repository.getMyRecipes()
            liveData.value = list
            Log.d(TAG,"Live data :${liveData.value}")
        }
    }

    // Function to insert a recipe
    fun insertRecipe(recipe: RecipeEntity) {
        viewModelScope.launch {
            repository.insertRecipe(recipe)
            liveData.value = myRecipeList.toTypedArray()
        }
    }

    // Function to remove a recipe
    fun removeRecipe(recipe: RecipeEntity) {
        viewModelScope.launch {
            repository.deleteRecipe(recipe)
            allRecipes() // Refresh the data after deletion
        }
    }
}

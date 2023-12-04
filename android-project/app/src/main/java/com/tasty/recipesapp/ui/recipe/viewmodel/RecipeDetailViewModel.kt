package com.tasty.recipesapp.ui.recipe.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.ui.recipe.RecipeDetailFragment

class RecipeDetailViewModel :ViewModel(){

    companion object {
        val TAG: String? = RecipeDetailViewModel::class.java.canonicalName
    }


    var recipe:MutableLiveData<RecipeModel> = MutableLiveData()

    fun fetchRecipeDetail(recipeId:Int, context: Context): RecipeModel? {
        val recipeRepository = RecipeRepository(context)

        val recipe=recipeRepository.getRecipe(recipeId)
        this.recipe.value=recipe
        Log.d(TAG,"Recipe: ${recipe?.id} ::: ${   recipe?.name}")
        return recipe

    }
}
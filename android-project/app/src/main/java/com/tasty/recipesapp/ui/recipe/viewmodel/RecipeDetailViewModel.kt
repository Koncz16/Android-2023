package com.tasty.recipesapp.ui.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.ui.recipe.RecipesFragment

class RecipeDetailViewModel : ViewModel(){
    var recipe:MutableLiveData<RecipeModel> = MutableLiveData()

        fun fetchRecipeDetail(recipeId:Int, context: Context) {
            val recipe = RecipeRepository(context).getRecipe(recipeId)
            this.recipe.value = recipe
        }


}
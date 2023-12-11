package com.tasty.recipesapp.ui

import android.app.Application
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.database.RecipeDatabase
import com.tasty.recipesapp.repository.recipe.RepositoryProvider

class App: Application() {
    // private val database by lazy { RecipeDatabase.getDatabase(this) }
    // val repository by lazy { RecipeRepository(database) }


    //private val recipeRepository = RepositoryProvider.recipeRepository

}
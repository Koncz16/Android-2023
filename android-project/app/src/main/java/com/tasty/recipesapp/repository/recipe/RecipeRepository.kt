package com.tasty.recipesapp.repository.recipe

import android.util.Log
import com.tasty.recipesapp.repository.recipe.dtos.RecipeDTO
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import com.google.gson.Gson
import com.tasty.recipesapp.repository.recipe.dtos.RecipeResultDTO
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.ui.recipe.RecipesFragment
import java.io.Reader
import android.content.Context
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModelList


class RecipeRepository(private val context: Context) {
    private val TAG: String? = RecipeRepository::class.java.canonicalName
    private val JSON_FILE_NAME = "all_recipes.json"
    private var recipeList:List<RecipeModel> = emptyList()
    private var myRecipeList:ArrayList<RecipeEntity> = ArrayList()


    // Function to read JSON data from a file in the assets directory
    // In the future this should be deleted and data should be fetched from a public API
     fun readRecipes(): List<RecipeDTO> {
        try {
            // Open the file as an input stream
            val inputStream = context.assets.open(JSON_FILE_NAME)

            // Use BufferedReader and InputStreamReader to read the file
            val reader: Reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))

            // Use Gson to deserialize JSON into RecipeResultDTO
            val result = Gson().fromJson(reader, RecipeResultDTO::class.java)

            // Return the list of RecipeDTO objects
            recipeList=result.results.toModelList()

            return result.results
        } catch (e: IOException) {
            Log.e(TAG, "Error reading recipes from JSON file", e)
            return emptyList()
        }
    }
        fun getRecipe(recipeID: Int): RecipeModel? {
            recipeList=readRecipes().toModelList()
            Log.d(TAG,"RecipeList size: ${recipeList.size}")
            return recipeList.find { it.id == recipeID }
        }

        fun insertRecipe(recipeEntity: RecipeEntity): Boolean {
            return myRecipeList.add(recipeEntity)
        }

        fun deleteRecipe(recipeEntity: RecipeEntity): Boolean {
            return myRecipeList.remove(recipeEntity)
        }

        fun getMyRecipes() = myRecipeList

}
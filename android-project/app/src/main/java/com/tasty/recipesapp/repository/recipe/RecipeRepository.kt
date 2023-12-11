package com.tasty.recipesapp.repository.recipe

import android.content.Context
import android.util.Log
import com.tasty.recipesapp.repository.recipe.dtos.RecipeDTO
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import com.google.gson.Gson
import com.tasty.recipesapp.repository.recipe.dtos.RecipeResultDTO
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import java.io.Reader
import com.tasty.recipesapp.database.RecipeDatabase
import com.tasty.recipesapp.repository.recipe.dao.RecipeDao
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModelList
import org.json.JSONObject


class RecipeRepository(private val recipeDao: RecipeDao) {
    private val TAG: String? = RecipeRepository::class.java.canonicalName
    private val JSON_FILE_NAME = "all_recipes.json"
    private var recipeList: List<RecipeModel> = emptyList()
    private var myRecipeList: ArrayList<Recipe> = ArrayList()


    // Function to read JSON data from a file in the assets directory
    // In the future this should be deleted and data should be fetched from a public API
    fun readRecipes(context: Context): List<RecipeModel> {
        try {
            // Open the file as an input stream
            val inputStream = context.assets.open(JSON_FILE_NAME)

            // Use BufferedReader and InputStreamReader to read the file
            val reader: Reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))

            // Use Gson to deserialize JSON into RecipeResultDTO
            val result = Gson().fromJson(reader, RecipeResultDTO::class.java)

            // Return the list of RecipeDTO objects
            recipeList = result.results.toModelList()

            return recipeList
        } catch (e: IOException) {
            Log.e(TAG, "Error reading recipes from JSON file", e)
            return emptyList()
        }
    }
    suspend fun deleteRecipeById(recipeID: Int){
        recipeDao.deleteRecipeById(recipeID)
    }
    suspend fun getRecipeById(recipeID: Int): RecipeModel?{
        val recipe = recipeDao.getRecipeById(recipeID)
        val jsonObject = JSONObject(recipe!!.json)
        val gson = Gson()
        jsonObject.apply{put("id", recipe.internalId)}
        val result=gson.fromJson(jsonObject.toString(), RecipeDTO::class.java)

        Log.d(TAG,"Result: ${result}")
        return result.toModel()
    }


    suspend fun insertRecipe(recipe: RecipeEntity) {
        recipeDao.insertRecipe(recipe)
    }

    fun getRecipe(context: Context, recipeID: Int): RecipeModel? {
        recipeList = readRecipes(context)
        return recipeList.find { it.id == recipeID }
    }

    suspend fun getAllRecipes(): List<RecipeModel> {
        recipeList = recipeDao.getAllRecipes().map {
            val jsonObject = JSONObject(it.json)
            val gson = Gson()
            jsonObject.apply { put("id", it.internalId) }
            gson.fromJson(jsonObject.toString(), RecipeDTO::class.java)
        }.toModelList()
        return recipeList

    }


}
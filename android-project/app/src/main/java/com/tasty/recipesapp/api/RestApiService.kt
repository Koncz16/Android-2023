package com.tasty.recipesapp.api

import com.tasty.recipesapp.repository.recipe.dtos.RecipeDTO
import com.tasty.recipesapp.repository.recipe.dtos.RecipeResultDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RecipeService {
    @GET("recipes/list")
    @Headers(
        "X-RapidAPI-Key: 5c5e31b829msh7f1f9636385e287p17278bjsn200807f8a815",
        "X-RapidAPI-Host: tasty.p.rapidapi.com"
    )
    suspend fun getRecipes(
        @Query("from") from: String,
        @Query("size") size: String,
        @Query("tags") tags: String? = null
    ): RecipeResultDTO

    @GET("recipes/get-more-info")
    @Headers(
        "X-RapidAPI-Key: 5c5e31b829msh7f1f9636385e287p17278bjsn200807f8a815",
        "X-RapidAPI-Host: tasty.p.rapidapi.com"
    )
    suspend fun getRecipeDetail(
        @Query("id") id : String,

    ): RecipeDTO

}

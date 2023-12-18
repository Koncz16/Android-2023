package com.tasty.recipesapp.repository.recipe.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tasty.recipesapp.repository.recipe.RecipeEntity
import com.tasty.recipesapp.repository.recipe.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity)
    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<UserEntity>
}
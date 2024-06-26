package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.RecipeDTO
import com.tasty.recipesapp.repository.recipe.mapper.CompilationMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.mapper.InstructionMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.mapper.PriceMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.mapper.SectionMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.mapper.SectionMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.mapper.TagMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.mapper.TotalTimeTierMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.mapper.UserRatingsMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.models.RecipeModel

class RecipeMapper {
    companion object {
        fun RecipeDTO.toModel(): RecipeModel {
            return RecipeModel(
                id=this.id,
                name = this.name,
                description=this.description,
                instructions= this.instructions?.toModelList(),
                tags = this.tags?.toModelList(),
                price = this.price?.toModel(),
                thumbnail_url=this.thumbnail_url,
                ratings= this.user_ratings?.toModel(),
                video_url=this.video_url,
                total_time_tier= this.total_time_tier?.toModel(),
                original_video_url= this.original_video_url,
                ingredients=this.ingredients
            )
        }
        fun List<RecipeDTO>.toModelList(): List<RecipeModel> = this.map { it.toModel() }
    }
}
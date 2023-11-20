package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.RecipeDTO
import com.tasty.recipesapp.repository.recipe.dtos.SectionDTO
import com.tasty.recipesapp.repository.recipe.mapper.ComponentMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.mapper.InstructionMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.mapper.PriceMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.mapper.TagMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.repository.recipe.models.SectionModel

class SectionMapper {
    companion object {
        fun SectionDTO.toModel(): SectionModel {
            return SectionModel(
                name = this.name,
                position = this.position,
                components = this.components.toModelList()
            )
        }
        fun List<SectionDTO>.toModelList(): List<SectionModel> = this.map { it.toModel() }
    }
}
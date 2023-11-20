package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.ShowDTO
import com.tasty.recipesapp.repository.recipe.models.ShowModel

class ShowMapper {
    companion object{
        fun ShowDTO.toModel(): ShowModel {
            return ShowModel(name = this.name, id = this.id)
        }
        fun List<ShowDTO>.toModelList(): List<ShowModel> = this.map { it.toModel() }
    }
}
package com.tasty.recipesapp.repository.recipe.dtos

data class SectionDTO(
    var components: List<ComponentDTO>,
    var name : String,
    var position : Int

)

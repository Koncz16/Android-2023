package com.tasty.recipesapp.repository.recipe.models

data class InstructionModel(
    val display_text: String?,
    val time: InstructionTime? )
data class InstructionTime(
    val start_time: Int?,
    val end_time: Int?)

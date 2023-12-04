package com.tasty.recipesapp.repository.recipe.dtos

data class CompilationDTO(
    val language: String?,
    val thumbnail_url: String?,
    val name: String?,
    val slug: String?,
    val aspect_ratio: String?,
    val keywords: List<String>?,
    val description: String?,
    val draft_status: String?,
    val video_url: String?,
    val beauty_url: String?,
    val buzz_id: Int?,
    val canonical_id: String?,
    val id: Int?,
    val country: String?,
    val is_shoppable: Boolean,
    val show: List<ShowDTO> = emptyList(),
    val created_at: Long?,
    val video_id: Int?,
    val facebook_posts: List<Any> = emptyList(),
    val thumbnail_alt_text: String?,
    val approved_at: Long?,
    val promotion: String?
)
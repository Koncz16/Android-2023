package com.tasty.recipesapp.repository.recipe.models

data class CompilationModel(
    val language: String?,
    val thumbnailUrl: String?,
    val name: String?,
    val slug: String?,
    val aspectRatio: String?,
    val keywords: List<String> = emptyList(),
    val description: String?,
    val draftStatus: String?,
    val videoUrl: String?,
    val beautyUrl: String?,
    val buzzId: Int?,
    val canonicalId: String?,
    val id: Int?,
    val country: String?,
    val isShoppable: Boolean?,
    val show: List<ShowModel> = emptyList(),
    val createdAt: Long?,
    val videoId: Int?,
    val facebookPosts: List<Any> = emptyList(),
    val thumbnailAltText: String?,
    val approvedAt: Long?,
    val promotion: String?
)
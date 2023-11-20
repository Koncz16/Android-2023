package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.CompilationDTO
import com.tasty.recipesapp.repository.recipe.dtos.RecipeDTO
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.mapper.ShowMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.models.CompilationModel
import com.tasty.recipesapp.repository.recipe.models.RecipeModel

class CompilationMapper {
    companion object{
        fun CompilationDTO.toModel(): CompilationModel {
            return CompilationModel(
                language = this.language,
                thumbnailUrl = this.thumbnail_url,
                name = this.name,
                slug = this.slug,
                aspectRatio = this.aspect_ratio,
                keywords = this.keywords ?: emptyList(),
                description = this.description,
                draftStatus = this.draft_status,
                videoUrl = this.video_url,
                beautyUrl = this.beauty_url,
                buzzId = this.buzz_id,
                canonicalId = this.canonical_id,
                id = this.id,
                country = this.country,
                isShoppable = this.is_shoppable,
                show = this.show.toModelList(),
                createdAt = this.created_at,
                videoId = this.video_id,
                facebookPosts = this.facebook_posts,
                thumbnailAltText = this.thumbnail_alt_text,
                approvedAt = this.approved_at,
                promotion = this.promotion
            )
        }
        fun List<CompilationDTO>.toModelList(): List<CompilationModel> = this.map { it.toModel() }

    }
}
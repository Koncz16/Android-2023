package com.tasty.recipesapp.ui.recipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.repository.recipe.RecipeEntity
import android.view.View
import android.widget.TextView


class MyRecipeListAdapter(private val recipes: List<RecipeEntity>) :
    RecyclerView.Adapter<MyRecipeListAdapter.MyRecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_recipe_item, parent, false)
        return MyRecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyRecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int = recipes.size

    inner class MyRecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recipeNameTextView: TextView = itemView.findViewById(R.id.recipeNameTextView)
        private val recipeDescriptionTextView: TextView =
            itemView.findViewById(R.id.recipeDescriptionTextView)

        fun bind(recipe: RecipeEntity) {
            recipeNameTextView.text = recipe.name
            recipeDescriptionTextView.text = recipe.description
        }
    }
}
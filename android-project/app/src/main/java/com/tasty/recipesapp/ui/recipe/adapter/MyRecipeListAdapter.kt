package com.tasty.recipesapp.ui.recipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.repository.recipe.Recipe
import android.view.View
import android.widget.TextView
import com.tasty.recipesapp.ui.profile.ProfileFragment


class MyRecipeListAdapter(private var recipes: List<Recipe>,
                          private val profileFragment: ProfileFragment,
                          private val context: Context
) : RecyclerView.Adapter<MyRecipeListAdapter.MyRecipeViewHolder>() {

    fun updateRecipes(newRecipes: List<Recipe>) {
        recipes = newRecipes
        notifyDataSetChanged()
    }



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

        fun bind(recipe: Recipe) {
            recipeNameTextView.text = recipe.name
            recipeDescriptionTextView.text = recipe.description
        }
    }
}
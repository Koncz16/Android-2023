package com.tasty.recipesapp.ui.recipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentDashboardBinding
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import java.text.FieldPosition


class RecipeListAdapter(
    private val recipeList:List<RecipeModel>,
    private val context: Context,
    private val onItemClickListener: (RecipeModel) -> Unit
):RecyclerView.Adapter<RecipeListAdapter.RecipeItemViewHolder>(){

    override fun onCreateViewHolder(parrent:ViewGroup, viewType: Int): RecipeItemViewHolder {
        // Create a new view, which defines the UI of the list item
        val binding=RecipeListItemBinding.inflate(LayoutInflater.from(context),parrent,false)
        return RecipeItemViewHolder(binding)
    }
    override fun getItemCount() :Int = recipeList.size

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        val currentRecipe = recipeList[position]
        holder.recipeTitleView.text=currentRecipe.name
    }

inner class RecipeItemViewHolder(binding: RecipeListItemBinding):
    RecyclerView.ViewHolder(binding.root){
    val recipeTitleView : TextView=binding.recipeItemTitleView
    val recipeDescriptionView : TextView =binding.recipeDescriptionView
    val recipeImageView : ImageView = binding.recipeImageView
    val recipeRatingView : TextView =binding.recipeRatingView

    init {
        binding.root.setOnClickListener{
            val currentPosition:Int = this.adapterPosition
            val currentRecipe : RecipeModel = recipeList[currentPosition]

            onItemClickListener(currentRecipe)
        }
    }
    }
}
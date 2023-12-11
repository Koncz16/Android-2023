package com.tasty.recipesapp.ui.recipe.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tasty.recipesapp.R
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.ui.profile.ProfileFragment
import com.tasty.recipesapp.ui.recipe.RecipesFragment

class RecipeListAdapter(
    var recipes: Array<RecipeModel>, private var onRecipeClickListener: OnRecipeClickListener
): RecyclerView.Adapter<RecipeListAdapter.ViewHolder>() {
    interface OnRecipeClickListener {
        fun onRecipeClick(recipe:RecipeModel)
    }
    companion object {
        val TAG: String? = RecipeListAdapter::class.java.canonicalName
    }
   inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val itemTitle:TextView=itemView.findViewById(R.id.recipe_title_view)
        val itemDescription:TextView=itemView.findViewById(R.id.recipe_description_view)
        val itemImage:ImageView=itemView.findViewById(R.id.recipe_image_view)
        val itemRating:TextView=itemView.findViewById(R.id.recipe_ratings_view)

       init{
           itemView.setOnClickListener{it :View ->
               val position:Int = this.adapterPosition
               val currentRecipe=recipes[position]
                    Log.d(TAG,"ItemView Clicked on id: ${currentRecipe.id}")
               val recipesFragment= RecipesFragment()
               //recipesFragment.navigateToRecipeDetail(currentRecipe)
               onRecipeClickListener.onRecipeClick(currentRecipe)
           }
       }

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent,false)
        return  ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentRecipe=recipes[position]

        Glide.with(holder.itemImage)
            .load(currentRecipe.thumbnail_url)
            .into(holder.itemImage)
        holder.itemTitle.text=currentRecipe.name
        holder.itemDescription.text=currentRecipe.description
        val ratingLabel="Rating:"
        holder.itemRating.text=ratingLabel.plus(" ").plus(currentRecipe.ratings?.score)

    }

}

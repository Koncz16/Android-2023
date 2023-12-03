package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentRecipeDetailBinding
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.ui.recipe.adapter.RecipeListAdapter
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeDetailViewModel

class RecipeDetailFragment : Fragment() {

    companion object {
        val TAG: String? = RecipeDetailFragment::class.java.canonicalName
    }

    private  lateinit var recipeListAdapter: RecipeListAdapter
    private lateinit var bindig:FragmentRecipeDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindig = FragmentRecipeDetailBinding.inflate(inflater,container,false)
        return  bindig.root
        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recipeId = arguments?.getInt(RecipesFragment.BUNDLE_EXTRA_SELECTED_RECIPE_ID)
        Log.d(TAG, "Show details for recipe with ID= $recipeId")
        // Inflate the layout for this fragment
        val viewModel =
            ViewModelProvider(this)[RecipeDetailViewModel::class.java]
        recipeId?.let{viewModel.fetchRecipeDetail(it,this.requireActivity())}

        viewModel.recipe.observe(viewLifecycleOwner){
            Log.d(TAG,"Selected recipe's details: $it")
            it?.let{updateViews(it)}
        }

    }

    private fun updateViews(recipeModel: RecipeModel) {
        bindig.recipeItemTitleView.text=recipeModel.name
        bindig.recipeDescriptionView.text=recipeModel.description
        Glide.with(requireActivity())
            .load(recipeModel.thumbnail_url)
            .centerCrop()
            .fallback(R.drawable.recipe_hub)
            .into(bindig.recipeImageView)

        val ratingLabel="Rating:"
        bindig.recipeRatingView.text=ratingLabel
            .plus(" ")
            .plus(recipeModel.user_ratings?.score)

        val instructionString = recipeModel.instructions.joinToString ("\n"){
            it.display_text
        }
    }



}
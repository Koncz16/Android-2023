package com.tasty.recipesapp.ui.recipe

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentRecipeDetailBinding
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import com.tasty.recipesapp.ui.recipe.adapter.InstructionsAdapter
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeDetailViewModel
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeListViewModel

class RecipeDetailFragment : Fragment() {

    companion object {
        val TAG: String? = RecipeDetailFragment::class.java.canonicalName
    }

    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RecipeDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.d(TAG, "Args: $arguments")
        val recipeId = arguments?.getInt("recipeID") ?: -1
        val source = arguments?.getString("sourcePage")
        Log.d(TAG, "Recipe id : ${recipeId}")
        Log.d(TAG, "Recipe source : ${source}")
        if (source == "ProfileFragment") {
            viewModel.getRecipeDetail(recipeId)
            viewModel.recipe.observe(viewLifecycleOwner, Observer { recipe ->
                if (recipe != null) {
                    binding.recipeTitle.text = recipe.name
                    val ratingLabel = "Rating:"
                    binding.recipeRatings.text = "$ratingLabel ${recipe.ratings?.score}"
                    val priceLabel = "Price:"
                    binding.recipePrice.text = "$priceLabel ${recipe.price?.total} HUF"
                    val timeLabel = "Preparation time:"
                    binding.recipeTotalTimeTier.text = "$timeLabel ${recipe.total_time_tier?.displayTier}"

                    Glide.with(requireContext())
                        .load(recipe.thumbnail_url)
                        .placeholder(R.drawable.rh_logo)
                        .into(binding.recipeImageView)

                    val instructionsAdapter = recipe.instructions?.let { InstructionsAdapter(it) }

                    binding.instructionsRecyclerView.adapter = instructionsAdapter
                    binding.instructionsRecyclerView.layoutManager = LinearLayoutManager(context)
                    binding.instructionsRecyclerView.addItemDecoration(
                        DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                    )
                }
            })
        } else {
            viewModel.getRecipeDetailFromApi(recipeId)
            viewModel.recipe.observe(viewLifecycleOwner, Observer { recipe ->
                if (recipe != null) {
                    Log.d(TAG, "Video :${recipe.original_video_url}")

                    binding.recipeTitle.text = recipe.name
                    val ratingLabel = "Rating:"
                    binding.recipeRatings.text = "$ratingLabel ${recipe.ratings?.score}"
                    val priceLabel = "Price:"
                    binding.recipePrice.text = "$priceLabel ${recipe.price?.total} HUF"
                    val timeLabel = "Preparation time:"
                    binding.recipeTotalTimeTier.text =
                        "$timeLabel ${recipe.total_time_tier?.displayTier}"

                    Glide.with(requireContext())
                        .load(recipe.thumbnail_url)
                        .placeholder(R.drawable.rh_logo)
                        .into(binding.recipeImageView)

                    val videoView = view.findViewById<VideoView>(R.id.videoView)

                    val videoUriString = recipe?.original_video_url.orEmpty()
                    val videoUri = Uri.parse(videoUriString)

                    val mediaController = MediaController(requireContext())
                    mediaController.setAnchorView(videoView)
                    videoView.setMediaController(mediaController)

                    videoView.setVideoURI(videoUri)

                    videoView.setOnPreparedListener { mp ->
                        mp.start()
                    }

                    val instructionsAdapter = recipe.instructions?.let { InstructionsAdapter(it) }

                    binding.instructionsRecyclerView.adapter = instructionsAdapter
                    binding.instructionsRecyclerView.layoutManager = LinearLayoutManager(context)
                    binding.instructionsRecyclerView.addItemDecoration(
                        DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                    )
                }
            })
        }

        // Inflate the layout for this fragment
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
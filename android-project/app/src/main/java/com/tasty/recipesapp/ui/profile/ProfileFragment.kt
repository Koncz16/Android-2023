package com.tasty.recipesapp.ui.profile

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentProfileBinding
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.ui.recipe.RecipesFragment
import com.tasty.recipesapp.ui.recipe.adapter.RecipeListAdapter
import com.tasty.recipesapp.ui.recipe.viewmodel.ProfileViewModel


class ProfileFragment : Fragment(), RecipeListAdapter.OnRecipeClickListener{
    companion object {
        val TAG: String? = ProfileFragment::class.java.canonicalName
    }

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ProfileViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "ProfileFragment - onCreateView() called")
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        super.onViewCreated(view, savedInstanceState)

        val fab: FloatingActionButton = binding.fab
        fab.setOnClickListener {
            Log.d(TAG, "On clicked")
            findNavController().navigate(R.id.action_profileFragment_to_newRecipeFragment)
        }

        val viewModel: ProfileViewModel by viewModels()


        val recipes: Array<RecipeModel> = emptyArray()
        val myAdapter = RecipeListAdapter(recipes, this)

        binding.myRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.myRecyclerView.adapter = myAdapter


        val liveData = viewModel.liveData

        liveData.observe(viewLifecycleOwner) { it ->
            myAdapter.recipes = it
            myAdapter.notifyDataSetChanged()
            it.forEach {
                Log.d(ContentValues.TAG, it.toString())

            }

        }
        context?.let { viewModel.getAllRecipes() }
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    override fun onRecipeClick(recipe:RecipeModel) {
        val recipeId=recipe.id
        Log.d(RecipesFragment.TAG,"onRecipeClick - Called()")

        val bundle = Bundle()
        bundle.putInt("recipeID", recipe.id)
        bundle.putString("sourcePage", "ProfileFragment")


        findNavController().navigate(
            R.id.action_profileFragment_to_recipeDetailFragment,
            bundle
        )
    }
}
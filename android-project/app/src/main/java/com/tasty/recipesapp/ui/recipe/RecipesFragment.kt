package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.ui.recipe.adapter.RecipeListAdapter
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeListViewModel

class RecipesFragment : Fragment(), RecipeListAdapter.OnRecipeClickListener {
    interface OnRecipeClickListener {
        fun onRecipeClick(recipe:RecipeModel)
    }
    companion object {
        val TAG: String? = RecipesFragment::class.java.canonicalName
    }

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        val view = binding.root

        val viewModel: RecipeListViewModel by viewModels()
        // context?.let { viewModel.loadInstructionData(it) }
        context?.let { viewModel.getAllRecipesFromApi() }

        val adapter = viewModel.liveData.value?.let { recipes ->
            context?.let { context ->
                RecipeListAdapter(recipes, this)
            }
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        // Inflate the layout for this fragment

        return view
    }

    fun navigateToRecipeDetail(recipe:RecipeModel){
        Log.d(TAG,"navigateToRecipeDetail - Called()")
        val bundle = Bundle()
        bundle.putInt("recipeID", recipe.id)

        findNavController().navigate(
            R.id.action_recipesFragment_to_recipeDetailFragment,
            bundle
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onRecipeClick(recipe:RecipeModel) {
        val recipeId=recipe.id
        Log.d(TAG,"onRecipeClick - Called()")
        val bundle = Bundle()
        bundle.putInt("recipeID", recipe.id)

        findNavController().navigate(
            R.id.action_recipesFragment_to_recipeDetailFragment,
            bundle
        )
    }
}

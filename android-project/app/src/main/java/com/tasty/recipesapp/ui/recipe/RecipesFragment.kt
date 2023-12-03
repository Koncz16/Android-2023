package com.tasty.recipesapp.ui.recipe

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.ui.home.DashboardFragment
import com.tasty.recipesapp.ui.recipe.adapter.RecipeListAdapter
import com.tasty.recipesapp.viewModel.recipe.RecipeListViewModel

class RecipesFragment : Fragment() {
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
        viewModel.readAllRecipes(this)

        val adapter = viewModel.liveData.value?.let { recipes ->
            context?.let { context ->
                RecipeListAdapter(recipes, context)
            }
        }

        // RecyclerView beállítása
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        // Inflate the layout for this fragment
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.tasty.recipesapp.ui.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentProfileBinding
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import com.tasty.recipesapp.ui.recipe.RecipesFragment
import com.tasty.recipesapp.ui.recipe.adapter.MyRecipeListAdapter
import com.tasty.recipesapp.ui.recipe.adapter.RecipeListAdapter
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeListViewModel
import com.tasty.recipesapp.ui.recipe.viewmodel.ProfileViewModel
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeDetailViewModel


class ProfileFragment : Fragment() {
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

        viewModel = context?.let { ProfileViewModel(it) }!!

        val adapter = viewModel.liveData.value?.let { recipes ->
            Log.d(TAG,"Live data : ${recipes}")
            context?.let { context ->
                MyRecipeListAdapter(recipes,this,context)
            }
        }
        binding.myRecyclerView.adapter = adapter
        binding.myRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.myRecyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        viewModel.liveData.observe(viewLifecycleOwner, { recipes ->
            Log.d(TAG,"liveData updated")
            adapter?.updateRecipes(recipes)
        })

        val fab: FloatingActionButton = binding.fab
        fab.setOnClickListener {
            Log.d(TAG, "On clicked")
            findNavController().navigate(R.id.action_profileFragment_to_newRecipeFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
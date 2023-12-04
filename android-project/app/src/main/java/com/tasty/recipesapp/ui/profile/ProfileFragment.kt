package com.tasty.recipesapp.ui.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentProfileBinding
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import com.tasty.recipesapp.ui.recipe.RecipesFragment

class ProfileFragment : Fragment() {
    companion object {
        val TAG: String? = ProfileFragment::class.java.canonicalName
    }

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "ProfileFragment - onCreateView() called")
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root


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
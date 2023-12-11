package com.tasty.recipesapp.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentNewRecipeBinding
import com.tasty.recipesapp.repository.recipe.Recipe
import com.tasty.recipesapp.ui.recipe.viewmodel.ProfileViewModel
import com.tasty.recipesapp.repository.recipe.RecipeEntity


class NewRecipeFragment : Fragment() {
    companion object {
        val TAG: String? = NewRecipeFragment::class.java.canonicalName
    }

    private var _binding: FragmentNewRecipeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ProfileViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewRecipeBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        val saveButton: Button = view.findViewById(R.id.buttonSave)

        saveButton.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val description = binding.editTextDescription.text.toString()
            val thumbnail_url = binding.editTextThumbnailUrl.text.toString()
            val user_ratings = binding.editTextRating.text.toString()
            val instruction1 = binding.editTextInstruction1.text.toString()
            val instruction2 = binding.editTextInstruction2.text.toString()

            if(name.isNotEmpty() || description.isNotEmpty() || thumbnail_url.isNotEmpty() ||user_ratings.isNotEmpty() || instruction1.isNotEmpty() || instruction2.isNotEmpty()){
                val jsonData = """
            {
                "name": "$name",
                "description": "$description",
                "thumbnail_url": "$thumbnail_url",
                "instructions": [
                {
                "display_text":"$instruction1"
                },{
                 "display_text":"$instruction2"}
                 ],
                "user_ratings":{
                        "score":"$user_ratings"
                }
            }
        """.trimIndent()
                val newRecipe = RecipeEntity(
                    json = jsonData
                )
                // Insert the new recipe using the ProfileViewModel
                viewModel.insertRecipe(newRecipe)
                Toast.makeText(requireContext(), "Recipe inserted successfully!", Toast.LENGTH_LONG)
                    .show()
                // Navigate back to the previous screen or wherever you want to go
                findNavController().navigateUp()
            } else{
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }

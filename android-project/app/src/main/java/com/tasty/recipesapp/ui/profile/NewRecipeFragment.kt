package com.tasty.recipesapp.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tasty.recipesapp.R
import com.tasty.recipesapp.repository.recipe.RecipeEntity
import com.tasty.recipesapp.ui.recipe.viewmodel.ProfileViewModel


class NewRecipeFragment : Fragment() {
    companion object {
        val TAG: String? = NewRecipeFragment::class.java.canonicalName
    }

    private lateinit var editTextName: EditText

    //private lateinit var layoutIngredients: LinearLayout
    //private lateinit var layoutInstructions: LinearLayout
    private lateinit var editTextDescription: EditText
    private lateinit var buttonSave: Button
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_new_recipe, container, false)

        // Initialize UI components
        editTextName = view.findViewById(R.id.editTextName)
        editTextDescription = view.findViewById(R.id.editTextDescription)
        //layoutIngredients = view.findViewById(R.id.layoutIngredients)
        //layoutInstructions = view.findViewById(R.id.layoutInstructions)
        buttonSave = view.findViewById(R.id.buttonSave)

        profileViewModel = context?.let { ProfileViewModel(it) }!!

        // Add onClickListener for Save button
        buttonSave.setOnClickListener {
            Log.d(TAG, "Save button clicked() ")
            saveRecipe()
        }


        // Add logic for dynamically adding fields for ingredients and instructions
        // You can use functions like addIngredientField() and addInstructionField()

        return view
    }

    private fun saveRecipe() {
        val recipeName = editTextName.text.toString()
        val recipeDescription = editTextDescription.text.toString()

        if (recipeName.isNotEmpty() && recipeDescription.isNotEmpty()) {
            val recipeEntity = RecipeEntity(
                name = recipeName,
                description = recipeDescription,
                //Add more parameters
            )
            Log.d(TAG, "Item inserted with name: ${recipeEntity.name}")
            context?.let { profileViewModel.insertRecipe(recipeEntity) }
            context?.let {
                profileViewModel.allRecipes()
                Log.d(TAG, "My Recipe List: ${profileViewModel.liveData.value}}")
                Toast.makeText(requireContext(), "Recipe inserted successfully!", Toast.LENGTH_LONG)
                    .show()
                findNavController().navigateUp()
            }
        }
            else{
                Toast.makeText(requireContext(), "Fill all boxes", Toast.LENGTH_LONG).show()

            }
        }

    }

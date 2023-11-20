package com.tasty.recipesapp.ui.recipe

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.ui.home.DashboardFragment
import com.tasty.recipesapp.viewModel.recipe.RecipeListViewModel

class RecipesFragment : Fragment() {
    companion object{
        val TAG:String? = RecipesFragment::class.java.canonicalName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"RecipesFragment - onCreateView() called")

        val view = FragmentRecipesBinding.inflate(layoutInflater)
        val recipes: Array<RecipeModel> = emptyArray()

        val viewModel: RecipeListViewModel by viewModels()
        val liveData = viewModel.liveData
        
        liveData.observe(viewLifecycleOwner) { it ->
            it.forEach{
                Log.d(ContentValues.TAG,"Name: ${it.name}")
                Log.d(ContentValues.TAG,"Description: ${it.description}")

                val instructions = it.instructions
                instructions.forEachIndexed { index, instruction ->
                    Log.d(ContentValues.TAG, "Instruction $index: ${instruction.display_text}")
                }
                val tags=it.tags
                tags.forEach{tag->
                    Log.d(ContentValues.TAG,"Tag: ${tag.displayName} : ${tag.type}")
                }
                Log.d(ContentValues.TAG,"Price: ${it.price.total}")
            }
        }
        viewModel.readAllRecipes(this)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }
}

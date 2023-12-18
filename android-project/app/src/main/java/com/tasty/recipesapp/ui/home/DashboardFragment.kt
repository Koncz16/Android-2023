package com.tasty.recipesapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentDashboardBinding
import com.tasty.recipesapp.ui.profile.ProfileFragment

class DashboardFragment : Fragment() {
    companion object{
        val TAG:String? = DashboardFragment::class.java.canonicalName
    }
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(layoutInflater)
        Log.d(TAG,"DashboardFragment - onCreateView() called")

        val registerButton: Button = binding.buttonRegister

        registerButton.setOnClickListener {
            Log.d(TAG, "buttonRegister - Clicked")
            findNavController().navigate(R.id.action_dashboardFragment_to_registerFragment)
        }
        // Inflate the layout for this fragment
        return binding.root    }
}
package com.tasty.recipesapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentDashboardBinding
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

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }
}
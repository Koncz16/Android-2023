package com.tasty.recipesapp.ui.home

// Import necessary libraries
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tasty.recipesapp.R  // Replace with your actual R class import
import com.tasty.recipesapp.databinding.FragmentLoginBinding
import com.tasty.recipesapp.ui.recipe.viewmodel.UserViewModel

class LogInFragment : Fragment() {

    companion object {
        val TAG: String? = LogInFragment::class.java.canonicalName
    }

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UserViewModel
    private lateinit var appPreferences: AppPreferences


    // Override onCreateView to inflate the fragment's layout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        appPreferences = AppPreferences(requireContext())
        val saveButton: Button = view.findViewById(R.id.loginButton)

        saveButton.setOnClickListener {
            val name = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (name.isNotEmpty() && password.isNotEmpty()) {
                val psw = viewModel.hashPassword(password)

                // Insert the new recipe using the ProfileViewModel
                viewModel.getUserID(name,psw)
                viewModel.userId.observe(viewLifecycleOwner) { userId ->
                    // Most a userId-ben megtalálod a visszaadott azonosítót
                    if (userId != null) {
                        if (userId.toInt() != 0 ) {
                            Toast.makeText(
                                requireContext(),
                                "Logged in successfully!",
                                Toast.LENGTH_LONG
                            )
                                .show()
                            Log.d(TAG, "Logged in with id $userId")
                            appPreferences.userId = userId

                            findNavController().navigateUp()
                        } else {
                            Toast.makeText(requireContext(), "User not found", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }

            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    // Add other necessary methods and logic for user registration
    // For example, handle button clicks, validate user input, and perform registration logic
}

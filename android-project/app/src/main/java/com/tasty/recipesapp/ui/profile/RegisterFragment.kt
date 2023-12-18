// Import necessary libraries
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tasty.recipesapp.R  // Replace with your actual R class import
import com.tasty.recipesapp.databinding.FragmentNewRecipeBinding
import com.tasty.recipesapp.databinding.FragmentRegisterBinding
import com.tasty.recipesapp.repository.recipe.RecipeEntity
import com.tasty.recipesapp.repository.recipe.UserEntity
import com.tasty.recipesapp.ui.recipe.viewmodel.ProfileViewModel
import com.tasty.recipesapp.ui.recipe.viewmodel.UserViewModel

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UserViewModel

    // Override onCreateView to inflate the fragment's layout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        val saveButton: Button = view.findViewById(R.id.registerButton)

        saveButton.setOnClickListener {
            val name = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (name.isNotEmpty() && password.isNotEmpty()) {

                val newuser = UserEntity(name=name, password = password)
                // Insert the new recipe using the ProfileViewModel
                viewModel.insertUser(newuser)
                Toast.makeText(requireContext(), "User inserted successfully!", Toast.LENGTH_LONG)
                    .show()
                findNavController().navigateUp()
                // Navigate back to the previous screen or wherever you want to go

            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    // Add other necessary methods and logic for user registration
    // For example, handle button clicks, validate user input, and perform registration logic
}

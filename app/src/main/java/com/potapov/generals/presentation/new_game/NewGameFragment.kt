package com.potapov.generals.presentation.new_game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.potapov.generals.R
import com.potapov.generals.databinding.FragmentNewGameBinding
import com.potapov.generals.domain.entity.Army
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewGameFragment : Fragment() {

    private var _binding: FragmentNewGameBinding? = null
    private val binding: FragmentNewGameBinding
        get() = _binding ?: throw RuntimeException("FragmentStartBinding == null")

    private val viewModel: NewGameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        binding.apply {
            btnStartBack.setOnClickListener { launchWelcomeFragment() }
            etStartUserName.doOnTextChanged { text, start, before, count ->
                viewModel.resetErrorInputName()
            }
            btnStartGame.setOnClickListener {
                viewModel.addUser(etStartUserName.text?.toString())
            }
        }
    }

    private fun observeViewModel() {
        viewModel.errorInputName.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.start_error_input_name)
            } else {
                null
            }
            binding.tilStartUserName.error = message
        }
        viewModel.shouldStartGame.observe(viewLifecycleOwner) {
            launchGameFragment(Army.RUSSIA)
        }
    }

    private fun launchGameFragment(army: Army) {
        findNavController().navigate(
            NewGameFragmentDirections.actionNewGameFragmentToGameFragment(army)
        )
    }

    private fun launchWelcomeFragment() {
        findNavController().navigate(
            NewGameFragmentDirections.actionNewGameFragmentToWelcomeFragment()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
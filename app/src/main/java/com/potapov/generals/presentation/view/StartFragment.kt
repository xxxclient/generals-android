package com.potapov.generals.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.potapov.generals.R
import com.potapov.generals.databinding.FragmentStartBinding
import com.potapov.generals.domain.entity.Army
import com.potapov.generals.presentation.view_model.StartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding: FragmentStartBinding
        get() = _binding ?: throw RuntimeException("FragmentStartBinding == null")

    private val viewModel: StartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
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
            StartFragmentDirections.actionStartFragmentToGameFragment(army)
        )
    }

    private fun launchWelcomeFragment() {
        findNavController().navigate(
            StartFragmentDirections.actionStartFragmentToWelcomeFragment()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
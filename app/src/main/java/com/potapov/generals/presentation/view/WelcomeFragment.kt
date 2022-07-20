package com.potapov.generals.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.potapov.generals.R
import com.potapov.generals.databinding.FragmentWelcomeBinding
import com.potapov.generals.presentation.view_model.WelcomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userList.observe(viewLifecycleOwner) {
            if (it.isEmpty()) binding.btnContinueGame.visibility = View.GONE
        }
        binding.apply {
            btnNewGame.setOnClickListener { launchStartFragment() }
            btnContinueGame.setOnClickListener { launchGameFragment() }
            btnExit.setOnClickListener { exitFromGame() }
        }
    }

    private fun exitFromGame() = activity?.apply {
        moveTaskToBack(true)
        finish()
    }

    private fun launchStartFragment() {
        findNavController().navigate(R.id.action_welcomeFragment_to_startFragment)
    }

    private fun launchGameFragment() {
        findNavController().navigate(R.id.action_welcomeFragment_to_gameFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
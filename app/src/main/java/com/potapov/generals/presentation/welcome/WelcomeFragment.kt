package com.potapov.generals.presentation.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.potapov.generals.R
import com.potapov.generals.databinding.FragmentWelcomeBinding
import com.potapov.generals.dialogs.YesNoDialogMode
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
            btnNewGame.setOnClickListener { launchNewGameFragment() }
            btnContinueGame.setOnClickListener { launchGameFragment() }
            btnExit.setOnClickListener {
                launchYesNoDialog(YesNoDialogMode.EXIT_GAME)
            }
        }
    }

    private fun exitFromGame() = activity?.apply {
        moveTaskToBack(true)
        finish()
    }

    private fun launchNewGameFragment() {
        findNavController().navigate(R.id.action_welcomeFragment_to_newGameFragment)
    }

    private fun launchGameFragment() {
        findNavController().navigate(R.id.action_welcomeFragment_to_gameFragment)
    }

    private fun launchYesNoDialog(mode: YesNoDialogMode) = findNavController().navigate(
        WelcomeFragmentDirections.actionWelcomeFragmentToYesNoDialog(mode)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
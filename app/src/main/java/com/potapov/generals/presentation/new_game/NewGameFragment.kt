package com.potapov.generals.presentation.new_game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.potapov.generals.R
import com.potapov.generals.databinding.FragmentNewGameBinding
import com.potapov.generals.domain.entity.Race
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
            btnNewGameBack.setOnClickListener { launchWelcomeFragment() }
            btnNewGameStart.setOnClickListener {
                val userRace = when (rgNewGameUserRace.checkedRadioButtonId) {
                    rbNewGameUserRaceNF.id -> Race.NORTHERN_FEDERATION.toString()
                    rbNewGameUserRaceWS.id -> Race.WESTERN_STATES.toString()
                    else -> null
                }

                viewModel.addUser(userRace)
            }
        }
    }

    private fun observeViewModel() {
        viewModel.errorInputName.observe(viewLifecycleOwner) {
            val message = if (it) getString(R.string.choose_race) else null
            showMessage(message)
        }
        viewModel.shouldStartGame.observe(viewLifecycleOwner) {
            launchGameFragment(Race.NORTHERN_FEDERATION)
        }
    }

    private fun launchGameFragment(race: Race) = findNavController().navigate(
        NewGameFragmentDirections.actionNewGameFragmentToGameFragment(race)
    )

    private fun launchWelcomeFragment() = findNavController().navigate(
        R.id.action_newGameFragment_to_welcomeFragment
    )

    private fun showMessage(message: String?) =
            Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
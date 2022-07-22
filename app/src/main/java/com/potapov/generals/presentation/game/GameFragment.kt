package com.potapov.generals.presentation.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.potapov.generals.databinding.FragmentGameBinding
import com.potapov.generals.dialogs.YesNoDialogMode
import com.potapov.generals.domain.entity.Building

class GameFragment : Fragment() {

    private val args by navArgs<GameFragmentArgs>()

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnGameBack.setOnClickListener { launchWelcomeFragment() }
            btnBattleDialog.setOnClickListener { launchYesNoDialog(YesNoDialogMode.START_BATTLE) }
            ivGameCommandCenter.setOnClickListener { launchBuildingFragment(Building.COMMAND_CENTER) }
            ivGameOilDerrick.setOnClickListener { launchBuildingFragment(Building.OIL_DERRICK) }
            ivGameReactor.setOnClickListener { launchBuildingFragment(Building.REACTOR) }
            ivGameBarracks.setOnClickListener { launchBuildingFragment(Building.BARRACKS) }
            ivGameAcademy.setOnClickListener { launchBuildingFragment(Building.ACADEMY) }
            ivGameLaboratory.setOnClickListener { launchBuildingFragment(Building.LABORATORY) }
            ivGameFactory.setOnClickListener { launchBuildingFragment(Building.FACTORY) }
            ivGameAirbase.setOnClickListener { launchBuildingFragment(Building.AIRBASE) }
            ivGameShipyard.setOnClickListener { launchBuildingFragment(Building.SHIPYARD) }
        }
    }

    private fun launchYesNoDialog(mode: YesNoDialogMode) = findNavController().navigate(
        GameFragmentDirections.actionGameFragmentToYesNoDialog(mode)
    )

    private fun launchBuildingFragment(building: Building) = findNavController().navigate(
        GameFragmentDirections.actionGameFragmentToBuildingFragment(building)
    )

    private fun launchWelcomeFragment() = findNavController().navigate(
        GameFragmentDirections.actionGameFragmentToWelcomeFragment()
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
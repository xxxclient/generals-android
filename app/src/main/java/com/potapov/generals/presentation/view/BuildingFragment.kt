package com.potapov.generals.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.potapov.generals.databinding.FragmentBuildingBinding
import com.potapov.generals.domain.entity.Army
import com.potapov.generals.domain.entity.Building
import com.potapov.generals.domain.entity.Unit

class BuildingFragment : Fragment() {

    private val args by navArgs<BuildingFragmentArgs>()

    private var _binding: FragmentBuildingBinding? = null
    private val binding: FragmentBuildingBinding
        get() = _binding ?: throw RuntimeException("FragmentBattleBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuildingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnBack.setOnClickListener { launchGameFragment(Army.RUSSIA) }
            tvBuildingName.text = args.building.name

            when (args.building) {
                Building.ACADEMY -> {
                    Unit.SHOOTER
                }
                Building.AIRBASE -> {
                    ivBuildingFirstUnit.setOnClickListener { launchUnitFragment(Unit.DRONE) }
                    ivBuildingSecondUnit.setOnClickListener { launchUnitFragment(Unit.SHOOTER) }
                    ivBuildingThirdUnit.setOnClickListener { launchUnitFragment(Unit.FIGHTER) }
                }
                Building.BARRACKS -> {
                    ivBuildingFirstUnit.setOnClickListener { launchUnitFragment(Unit.SHOOTER) }
                    ivBuildingSecondUnit.setOnClickListener { launchUnitFragment(Unit.SNIPER) }
                    ivBuildingThirdUnit.setOnClickListener { launchUnitFragment(Unit.GRENADE_LAUNCHER) }
                }
                Building.COMMAND_CENTER -> {
                    Unit.SHOOTER
                }
                Building.FACTORY -> {
                    ivBuildingFirstUnit.setOnClickListener { launchUnitFragment(Unit.ARMORED_CAR) }
                    ivBuildingSecondUnit.setOnClickListener { launchUnitFragment(Unit.HOWITZER) }
                    ivBuildingThirdUnit.setOnClickListener { launchUnitFragment(Unit.TANK) }
                }
                Building.LABORATORY -> {
                    Unit.SHOOTER
                }
                Building.OIL_DERRICK -> {
                    Unit.SHOOTER
                }
                Building.REACTOR -> {
                    Unit.SHOOTER
                }
                Building.SHIPYARD -> {
                    ivBuildingFirstUnit.setOnClickListener { launchUnitFragment(Unit.BOAT) }
                    ivBuildingSecondUnit.setOnClickListener { launchUnitFragment(Unit.FRIGATE) }
                    ivBuildingThirdUnit.setOnClickListener { launchUnitFragment(Unit.SUBMARINE) }
                }
            }
        }
    }

    private fun launchUnitFragment(unit: Unit) = findNavController().navigate(
        BuildingFragmentDirections.actionBuildingFragmentToUnitFragment(unit)
    )

    private fun launchGameFragment(army: Army) = findNavController().navigate(
        BuildingFragmentDirections.actionBuildingFragmentToGameFragment(army)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
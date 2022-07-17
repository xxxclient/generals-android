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
import com.potapov.generals.domain.entity.UnitType

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
                    UnitType.SHOOTER
                }
                Building.AIRBASE -> {
                    ivBuildingFirstUnit.setOnClickListener { launchUnitFragment(UnitType.DRONE) }
                    ivBuildingSecondUnit.setOnClickListener { launchUnitFragment(UnitType.HELICOPTER) }
                    ivBuildingThirdUnit.setOnClickListener { launchUnitFragment(UnitType.FIGHTER) }
                }
                Building.BARRACKS -> {
                    ivBuildingFirstUnit.setOnClickListener { launchUnitFragment(UnitType.SHOOTER) }
                    ivBuildingSecondUnit.setOnClickListener { launchUnitFragment(UnitType.SNIPER) }
                    ivBuildingThirdUnit.setOnClickListener { launchUnitFragment(UnitType.GRENADE_LAUNCHER) }
                }
                Building.COMMAND_CENTER -> {
                    UnitType.SHOOTER
                }
                Building.FACTORY -> {
                    ivBuildingFirstUnit.setOnClickListener { launchUnitFragment(UnitType.ARMORED_CAR) }
                    ivBuildingSecondUnit.setOnClickListener { launchUnitFragment(UnitType.HOWITZER) }
                    ivBuildingThirdUnit.setOnClickListener { launchUnitFragment(UnitType.TANK) }
                }
                Building.LABORATORY -> {
                    UnitType.SHOOTER
                }
                Building.OIL_DERRICK -> {
                    UnitType.SHOOTER
                }
                Building.REACTOR -> {
                    UnitType.SHOOTER
                }
                Building.SHIPYARD -> {
                    ivBuildingFirstUnit.setOnClickListener { launchUnitFragment(UnitType.BOAT) }
                    ivBuildingSecondUnit.setOnClickListener { launchUnitFragment(UnitType.FRIGATE) }
                    ivBuildingThirdUnit.setOnClickListener { launchUnitFragment(UnitType.SUBMARINE) }
                }
            }
        }
    }

    private fun launchUnitFragment(unit: UnitType) = findNavController().navigate(
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
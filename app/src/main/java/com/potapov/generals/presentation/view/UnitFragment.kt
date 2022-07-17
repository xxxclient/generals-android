package com.potapov.generals.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.potapov.generals.databinding.FragmentUnitBinding
import com.potapov.generals.domain.entity.Building

class UnitFragment : Fragment() {

    private val args by navArgs<UnitFragmentArgs>()

    private var _binding: FragmentUnitBinding? = null
    private val binding: FragmentUnitBinding
        get() = _binding ?: throw RuntimeException("FragmentBattleBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUnitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnUnitBack.setOnClickListener { launchBuildingFragment(Building.BARRACKS) }
            tvBuildingName.text = args.unit.name
        }
    }

    private fun launchBuildingFragment(building: Building) = findNavController().navigate(
        UnitFragmentDirections.actionUnitFragmentToBuildingFragment(building)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
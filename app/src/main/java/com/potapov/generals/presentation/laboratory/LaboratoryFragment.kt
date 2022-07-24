package com.potapov.generals.presentation.laboratory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.potapov.generals.databinding.FragmentBuildingBinding
import com.potapov.generals.databinding.FragmentLaboratoryBinding
import com.potapov.generals.domain.entity.Army
import com.potapov.generals.domain.entity.Building
import com.potapov.generals.domain.entity.UnitType
import com.potapov.generals.presentation.battle.BattleFragmentDirections

class LaboratoryFragment : Fragment() {

    private var _binding: FragmentLaboratoryBinding? = null
    private val binding: FragmentLaboratoryBinding
        get() = _binding ?: throw RuntimeException("FragmentBattleBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLaboratoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnLaboratoryBack.setOnClickListener { launchGameFragment(Army.RUSSIA) }
        }
    }

    private fun launchGameFragment(army: Army) = findNavController().navigate(
        LaboratoryFragmentDirections.actionLaboratoryFragmentToGameFragment(army)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
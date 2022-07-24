package com.potapov.generals.presentation.laboratory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.potapov.generals.databinding.FragmentLaboratoryBinding
import com.potapov.generals.domain.entity.Race

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
            btnLaboratoryBack.setOnClickListener { launchGameFragment(Race.NORTHERN_FEDERATION) }
        }
    }

    private fun launchGameFragment(race: Race) = findNavController().navigate(
        LaboratoryFragmentDirections.actionLaboratoryFragmentToGameFragment(race)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
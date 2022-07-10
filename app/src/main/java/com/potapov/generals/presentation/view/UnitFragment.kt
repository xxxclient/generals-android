package com.potapov.generals.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.potapov.generals.databinding.FragmentBattleBinding
import com.potapov.generals.databinding.FragmentUnitBinding
import com.potapov.generals.domain.entity.Statistic

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

        binding.tvBuildingName.text = args.unit.name
    }

    private fun launchGameFragment(statistic: Statistic) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.potapov.generals.presentation.battle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.potapov.generals.databinding.FragmentBattleBinding
import com.potapov.generals.domain.entity.Race

class BattleFragment : Fragment() {

    private val args by navArgs<BattleFragmentArgs>()

    private var _binding: FragmentBattleBinding? = null
    private val binding: FragmentBattleBinding
        get() = _binding ?: throw RuntimeException("FragmentBattleBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBattleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnBattleBack.setOnClickListener { launchGameFragment(Race.NORTHERN_FEDERATION) }
        }
    }

    private fun launchGameFragment(race: Race) = findNavController().navigate(
        BattleFragmentDirections.actionBattleFragmentToGameFragment(race)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.potapov.generals.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.potapov.generals.databinding.FragmentGameBinding
import com.potapov.generals.domain.entity.Statistic

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
        binding.btnBattleDialog.setOnClickListener { showBattleDialog(true) }
        binding.dialogBattle.btnToBattle.setOnClickListener {
            launchBattleFragment(Statistic.DEFAULT)
        }
    }

    private fun launchBattleFragment(statistic: Statistic) {
        findNavController().navigate(
            GameFragmentDirections.actionGameFragmentToBattleFragment(statistic)
        )
    }

    private fun showBattleDialog(show: Boolean) {
        binding.dialogBattle.root.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
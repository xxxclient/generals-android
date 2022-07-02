package com.potapov.generals.presentation.view

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.potapov.generals.databinding.DialogBattleBinding
import com.potapov.generals.databinding.FragmentGameBinding
import com.potapov.generals.domain.entity.Statistic

class GameFragment : Fragment() {

    private val args by navArgs<GameFragmentArgs>()

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    private var _bindingDialogBattle: DialogBattleBinding? = null
    private val bindingDialogBattle: DialogBattleBinding
        get() = _bindingDialogBattle ?: throw RuntimeException("DialogBattleBinding == null")

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
        binding.btnBattleDialog.setOnClickListener {
            _bindingDialogBattle = DialogBattleBinding.inflate(layoutInflater)
            showBattleDialog()
        }
    }

    private fun showBattleDialog() = Dialog(requireContext()).apply {
        window?.setBackgroundDrawable(ColorDrawable(android.R.color.transparent))
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(bindingDialogBattle.root)
        bindingDialogBattle.btnToBattle.setOnClickListener {
            dismiss()
            launchBattleFragment(Statistic.DEFAULT)
        }
        show()
    }

    private fun launchBattleFragment(statistic: Statistic) = findNavController().navigate(
        GameFragmentDirections.actionGameFragmentToBattleFragment(statistic)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingDialogBattle = null
        _binding = null
    }
}
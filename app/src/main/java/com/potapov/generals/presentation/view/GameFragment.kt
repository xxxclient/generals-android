package com.potapov.generals.presentation.view

import android.app.Dialog
import android.graphics.Color.TRANSPARENT
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.potapov.generals.databinding.DialogBattleBinding
import com.potapov.generals.databinding.FragmentGameBinding
import com.potapov.generals.domain.entity.Building
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
        binding.apply {
            btnGameBack.setOnClickListener { launchWelcomeFragment() }
            btnBattleDialog.setOnClickListener {
                _bindingDialogBattle = DialogBattleBinding.inflate(layoutInflater)
                showBattleDialog()
            }
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

    private fun showBattleDialog() = Dialog(requireContext()).apply {
        setCanceledOnTouchOutside(false)
        setCancelable(false)
        window?.apply {
            setFlags(
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
            )
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
            setBackgroundDrawable(ColorDrawable(TRANSPARENT))
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(bindingDialogBattle.root)
        bindingDialogBattle.btnToBattle.setOnClickListener {
            dismiss()
            launchBattleFragment(Statistic.DEFAULT)
        }
        show()
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
    }

    private fun launchBattleFragment(statistic: Statistic) = findNavController().navigate(
        GameFragmentDirections.actionGameFragmentToBattleFragment(statistic)
    )

    private fun launchBuildingFragment(building: Building) = findNavController().navigate(
        GameFragmentDirections.actionGameFragmentToBuildingFragment(building)
    )

    private fun launchWelcomeFragment() = findNavController().navigate(
        GameFragmentDirections.actionGameFragmentToWelcomeFragment()
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingDialogBattle = null
        _binding = null
    }
}
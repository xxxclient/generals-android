package com.potapov.generals.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.potapov.generals.R
import com.potapov.generals.databinding.DialogYesNoBinding
import com.potapov.generals.domain.entity.Statistic

class YesNoDialog : DialogFragment() {

    private var _binding: DialogYesNoBinding? = null
    private val binding: DialogYesNoBinding
        get() = _binding ?: throw RuntimeException("DialogYesNoBinding == null")

    private val args by navArgs<YesNoDialogArgs>()

    private val yesNoModeExitGameTitle by lazy {
        requireContext().getString(R.string.yes_no_mode_exit_game_title)
    }
    private val yesNoModeExitGameDescription by lazy {
        requireContext().getString(R.string.yes_no_mode_exit_game_description)
    }

    private val yesNoModeStartBattleTitle by lazy {
        requireContext().getString(R.string.yes_no_mode_start_battle_title)
    }
    private val yesNoModeStartBattleDescription by lazy {
        requireContext().getString(R.string.yes_no_mode_start_battle_description)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogYesNoBinding.inflate(LayoutInflater.from(context))

        initMode()
        // TODO: Проверить что нужно requireActivity() requireContext()
        val dialog = AlertDialog.Builder(requireActivity()).setView(binding.root).create()
        return initDialog(dialog)
    }

    private fun initDialog(dialog: AlertDialog) = dialog.apply {
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
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
    }

    private fun initMode() {
        binding.apply {
            when (args.mode) {
                YesNoDialogMode.EXIT_GAME -> {
                    tvYesNoDialogTitle.text = yesNoModeExitGameTitle
                    tvYesNoDialogDescription.text = yesNoModeExitGameDescription
                    btnYesNoDialogOk.setOnClickListener { exitFromGame() }
                    btnYesNoDialogCancel.setOnClickListener { dismiss() }
                }
                YesNoDialogMode.START_BATTLE -> {
                    tvYesNoDialogTitle.text = yesNoModeStartBattleTitle
                    tvYesNoDialogDescription.text = yesNoModeStartBattleDescription
                    btnYesNoDialogOk.setOnClickListener { launchBattleFragment(Statistic.DEFAULT) }
                    btnYesNoDialogCancel.setOnClickListener { dismiss() }
                }
            }
        }
    }

    private fun launchBattleFragment(statistic: Statistic) = findNavController().navigate(
        YesNoDialogDirections.actionYesNoDialogToBattleFragment(statistic)
    )

    private fun exitFromGame() = activity?.apply {
        dismiss()
        moveTaskToBack(true)
        finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
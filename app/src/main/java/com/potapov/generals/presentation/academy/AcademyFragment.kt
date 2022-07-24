package com.potapov.generals.presentation.academy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.potapov.generals.databinding.FragmentAcademyBinding
import com.potapov.generals.domain.entity.Race

class AcademyFragment : Fragment() {

    private var _binding: FragmentAcademyBinding? = null
    private val binding: FragmentAcademyBinding
        get() = _binding ?: throw RuntimeException("FragmentBattleBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAcademyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnAcademyBack.setOnClickListener { launchGameFragment(Race.NORTHERN_FEDERATION) }
        }
    }

    private fun launchGameFragment(race: Race) = findNavController().navigate(
        AcademyFragmentDirections.actionAcademyFragmentToGameFragment(race)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
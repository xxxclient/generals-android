package com.potapov.generals.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.potapov.generals.databinding.FragmentStartBinding
import com.potapov.generals.domain.entity.Army

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding: FragmentStartBinding
        get() = _binding ?: throw RuntimeException("FragmentStartBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRussia.setOnClickListener { launchGameFragment(Army.RUSSIA) }
        binding.btnChina.setOnClickListener { launchGameFragment(Army.CHINA) }
        binding.btnUsa.setOnClickListener { launchGameFragment(Army.USA) }
    }

    private fun launchGameFragment(army: Army) {
        findNavController().navigate(
            StartFragmentDirections.actionStartFragmentToGameFragment(army)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
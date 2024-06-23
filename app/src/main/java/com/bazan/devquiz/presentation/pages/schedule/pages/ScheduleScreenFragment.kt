package com.bazan.devquiz.presentation.pages.schedule.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bazan.devquiz.R
import com.bazan.devquiz.databinding.FragmentScheduleScreenBinding
import com.bazan.devquiz.presentation.components.CustomAppBar

class ScheduleScreenFragment : Fragment() {
    private var _binding: FragmentScheduleScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var customAppBar: CustomAppBar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScheduleScreenBinding.inflate(inflater, container, false)
        initComponent()
        return binding.root
    }

    private fun initComponent() {
        val appBarView = binding.root.findViewById<View>(R.id.appBarSchedule)
        customAppBar = CustomAppBar(requireContext(), appBarView, "Programa tu pregunta", onGoBackSubmit = {
            findNavController().popBackStack()
        })
    }
}
package com.bazan.devquiz.presentation.pages.question.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bazan.devquiz.R
import com.bazan.devquiz.databinding.FragmentQuestionScreenBinding
import com.bazan.devquiz.presentation.components.CustomAppBar

class QuestionScreenFragment : Fragment() {
    private var _binding: FragmentQuestionScreenBinding? = null
    private val binding get() = _binding!!

    lateinit var customAppBar: CustomAppBar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionScreenBinding.inflate(inflater, container, false)
        initComponents()
        return binding.root
    }

    private fun initComponents() {
        val appBarView = binding.root.findViewById<View>(R.id.appBarQuestionScreen)
        customAppBar = CustomAppBar(requireContext(), appBarView, "Pregunta", onGoBackSubmit = {
            findNavController().popBackStack()
        })
    }
}
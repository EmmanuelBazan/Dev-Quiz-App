package com.bazan.devquiz.presentation.pages.home.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bazan.devquiz.R
import com.bazan.devquiz.databinding.FragmentHomeScreenBinding
import com.bazan.devquiz.presentation.components.CustomAppBar
import com.bazan.devquiz.presentation.pages.home.adapters.QuestionReminderListAdapter
import com.bazan.devquiz.presentation.pages.home.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeScreenFragment : Fragment() {
    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var customAppBar: CustomAppBar

    private val homeViewModel: HomeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        initComponents()
        initListeners()
        initRemindersList()
        return binding.root
    }

    private fun initComponents() {
        val appBarView = binding.root.findViewById<View>(R.id.appBarHomeScreen)
        customAppBar = CustomAppBar(
            requireContext(),
            appBarView,
            "Dev Quiz",
            onGoBackSubmit = {},
            onlyTitle = true
        )
    }

    private fun initListeners() {
        binding.btnAddReminder.setOnClickListener{
            val action = HomeScreenFragmentDirections.actionHomeScreenFragmentToSelectTopicFragment()
            findNavController().navigate(action)
        }
    }

    private fun initRemindersList() {
        homeViewModel.questionReminders.observe(requireActivity()) { reminders ->
            if (reminders != null) {
                val recyclerView =
                    binding.root.findViewById<RecyclerView>(R.id.recyclerViewQuestionsReminders)

                recyclerView.layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL, false
                )

                recyclerView.adapter = QuestionReminderListAdapter(reminders)
            }
        }
    }
}
package com.bazan.devquiz.presentation.pages.home.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bazan.devquiz.R
import com.bazan.devquiz.databinding.FragmentHomeScreenBinding
import com.bazan.devquiz.presentation.pages.home.adapters.QuestionReminderListAdapter
import com.bazan.devquiz.presentation.pages.home.viewModel.HomeViewModel

class HomeScreenFragment : Fragment() {
    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeScreenBinding.inflate(inflater,container,false)
        initRemindersList()
        return binding.root
    }

    private fun initRemindersList() {
        homeViewModel.questionReminders.observe(requireActivity()) {reminders ->
            if (reminders != null) {
                val recyclerViewFiles =
                    binding.root.findViewById<RecyclerView>(R.id.recyclerViewQuestionsReminders)

                recyclerViewFiles.layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL, false
                )

                recyclerViewFiles.adapter = QuestionReminderListAdapter(reminders)
            }
        }
    }
}
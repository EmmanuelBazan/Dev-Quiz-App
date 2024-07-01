package com.bazan.devquiz.presentation.pages.topic.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bazan.devquiz.R
import com.bazan.devquiz.databinding.FragmentSelectTopicBinding
import com.bazan.devquiz.presentation.components.CustomAppBar
import com.bazan.devquiz.presentation.pages.home.adapters.QuestionReminderListAdapter
import com.bazan.devquiz.presentation.pages.topic.adapters.TopicListAdapter
import com.bazan.devquiz.presentation.pages.topic.components.DialogDifficulty
import com.bazan.devquiz.presentation.pages.topic.viewModel.SelectTopicViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectTopicFragment : Fragment() {
    private var _binding: FragmentSelectTopicBinding? = null
    private val binding get() = _binding!!

    private lateinit var customAppBar: CustomAppBar
    private lateinit var dialogDifficulty: DialogDifficulty

    private val selectTopicViewModel: SelectTopicViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectTopicBinding.inflate(inflater, container, false)
        initComponents()
        initTopicList()
        return binding.root
    }

    private fun initComponents() {
        val appBarView = binding.root.findViewById<View>(R.id.appBarSelectTopic)
        customAppBar = CustomAppBar(
            requireContext(),
            appBarView,
            "Tecnologias",
            onGoBackSubmit = {
                findNavController().popBackStack()
            })

        dialogDifficulty = DialogDifficulty(onSubmitBtnOkListener = {
            val action =
                SelectTopicFragmentDirections.actionSelectTopicFragmentToScheduleScreenFragment()
            findNavController().navigate(action)
        }, R.layout.dialog_difficulty)
    }

    private fun initTopicList() {
        selectTopicViewModel.topicList.observe(requireActivity()) { topics ->
            if (topics != null) {
                val gridView =
                    binding.root.findViewById<GridView>(R.id.gridViewTopics)

                val adapter = TopicListAdapter(requireContext(), topics, onClick = {
                    dialogDifficulty.show(parentFragmentManager, "DialogDifficulty")
                })

                gridView.adapter = adapter
            }
        }
    }
}
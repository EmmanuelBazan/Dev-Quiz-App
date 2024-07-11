package com.bazan.devquiz.presentation.pages.home.pages

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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

    private val notificationPermissionRequestCode = 1

    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkNotificationPermission()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        initComponents()
        initListeners()
        initRemindersList()
        homeViewModel.getAllRemindersFull()
        return binding.root
    }

    private fun initComponents() {

    }

    private fun initListeners() {
        binding.btnAddReminder.setOnClickListener {
            val action =
                HomeScreenFragmentDirections.actionHomeScreenFragmentToSelectTopicFragment()
            findNavController().navigate(action)
        }
    }

    private fun initRemindersList() {
        homeViewModel.reminderFullList.observe(requireActivity()) { reminders ->
            if (reminders != null) {
                val recyclerView =
                    binding.root.findViewById<RecyclerView>(R.id.recyclerViewQuestionsReminders)

                recyclerView.layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL, false
                )

                recyclerView.adapter = QuestionReminderListAdapter(reminders, onClick = {idTechnology,idDifficulty ->
                    val action = HomeScreenFragmentDirections.actionHomeScreenFragmentToQuestionScreenFragment(idTechnology,idDifficulty)
                    findNavController().navigate(action)
                })
            }
        }
    }

    private fun checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Android 13 (API nivel 33)
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
                // No tenemos el permiso, solicitarlo
                ActivityCompat.requestPermissions(requireActivity(),
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS), notificationPermissionRequestCode)
            } else {
                // Ya tenemos el permiso, proceder con la lógica de notificaciones
                setupNotifications()
            }
        } else {
            // Para versiones anteriores a Android 13
            setupNotifications()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            notificationPermissionRequestCode -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Permiso concedido, proceder con la lógica de notificaciones
                    setupNotifications()
                } else {
                    // Permiso denegado, manejar la situación
                    Toast.makeText(requireContext(), "Permiso para notificaciones denegado", Toast.LENGTH_SHORT).show()
                }
                return
            }
            // Otras solicitudes de permisos pueden manejarse aquí
        }
    }

    private fun setupNotifications() {
        // Tu lógica de configuración de notificaciones
    }
}
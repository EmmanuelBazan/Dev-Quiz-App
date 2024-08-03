package com.bazan.devquiz.presentation.pages.splash.pages

import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.bazan.devquiz.BuildConfig
import com.bazan.devquiz.R
import com.bazan.devquiz.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {
    private var _binding: FragmentSplashScreenBinding? = null
    private val binding get() = _binding!!

    private var shouldRestart: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        initComponents()
        initUI()
        initDelayedTime()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Cambiar el color de la barra de estado
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.mainGreen)
    }

    override fun onResume() {
        super.onResume()
        if (shouldRestart) {
            initDelayedTime()
        }
    }

    override fun onStop() {
        super.onStop()
        shouldRestart = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        shouldRestart = false

        val isDarkMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

        // Cambiar el color de la barra de estado según el modo
        if (isDarkMode) {
            activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.black_25)
        } else {
            activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.white_f2)
        }
    }

    private fun initComponents() {

    }

    private fun initUI() {
        getCodeVersion()
    }

    private fun getCodeVersion() {
        binding.txtVersion.text = "Versión ${BuildConfig.VERSION_NAME}"
    }

    private fun initDelayedTime() {
        Handler(Looper.getMainLooper()).postDelayed({
            val action =
                SplashScreenFragmentDirections.actionSplashScreenFragmentToHomeScreenFragment()
            findNavController().navigate(action)
        }, 3000)
    }
}
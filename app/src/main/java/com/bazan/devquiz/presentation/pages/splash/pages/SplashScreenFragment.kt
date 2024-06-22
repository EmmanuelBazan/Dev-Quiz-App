package com.bazan.devquiz.presentation.pages.splash.pages

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bazan.devquiz.BuildConfig
import com.bazan.devquiz.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {
    private var _binding: FragmentSplashScreenBinding? = null
    private val binding get() = _binding!!

    private var shouldRestart: Boolean = false;

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
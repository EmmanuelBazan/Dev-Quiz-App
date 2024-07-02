package com.bazan.devquiz.presentation.pages.question.pages

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.animation.doOnEnd
import androidx.core.view.GestureDetectorCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.viewpager2.widget.ViewPager2
import com.bazan.devquiz.R
import com.bazan.devquiz.databinding.FragmentQuestionScreenBinding
import com.bazan.devquiz.presentation.components.CustomAppBar
import com.bazan.devquiz.presentation.pages.question.adapters.CardListAdapter
import kotlin.math.abs

class QuestionScreenFragment : Fragment() {
    private var _binding: FragmentQuestionScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var customAppBar: CustomAppBar
    private lateinit var viewPager: ViewPager2
    private lateinit var cardAdapter: CardListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionScreenBinding.inflate(inflater, container, false)
        initComponents()
        initListeners()
        return binding.root
    }

    private fun initComponents() {
        val appBarView = binding.root.findViewById<View>(R.id.appBarQuestionScreen)
        customAppBar = CustomAppBar(requireContext(), appBarView, "Pregunta", onGoBackSubmit = {
            findNavController().popBackStack()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = requireView().findViewById(R.id.viewPagerQuestionScreen)
        cardAdapter = CardListAdapter(listOf(1,2,3,4,5),requireContext())
        viewPager.adapter = cardAdapter

        // Configurar el PagerSnapHelper para el centrado
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(null)

        // Opcional: Cambiar la orientación del ViewPager2
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun initListeners() {
    }






}
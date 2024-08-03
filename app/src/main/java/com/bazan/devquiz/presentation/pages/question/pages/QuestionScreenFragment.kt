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
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.viewpager2.widget.ViewPager2
import com.bazan.devquiz.BuildConfig
import com.bazan.devquiz.R
import com.bazan.devquiz.databinding.FragmentQuestionScreenBinding
import com.bazan.devquiz.presentation.components.CustomAppBar
import com.bazan.devquiz.presentation.pages.question.adapters.CardListAdapter
import com.bazan.devquiz.presentation.pages.question.viewModel.QuestionViewModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import dagger.hilt.android.AndroidEntryPoint
import java.util.Arrays
import kotlin.math.abs
import kotlin.random.Random

@AndroidEntryPoint
class QuestionScreenFragment : Fragment() {
    private var _binding: FragmentQuestionScreenBinding? = null
    private val binding get() = _binding!!

    private var mInterstitialAd: InterstitialAd? = null

    private lateinit var customAppBar: CustomAppBar
    private lateinit var viewPager: ViewPager2
    private lateinit var cardAdapter: CardListAdapter

    private val questionViewModel: QuestionViewModel by activityViewModels()
    private val args: QuestionScreenFragmentArgs by navArgs()

    val interstitialId = BuildConfig.INTERSTITIAL_ID

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionScreenBinding.inflate(inflater, container, false)
        initComponents()
        initListeners()
        questionViewModel.getQuestionByTechAndDifficulty(args.idTechnology, args.idDifficulty)
        return binding.root
    }

    private fun initInterstitial() {
        val testDeviceIds = Arrays.asList("176DA4119D4BFCC4FB4CA4B49D4B529F")
        val configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
        MobileAds.setRequestConfiguration(configuration)

        var adRequest = AdRequest.Builder().build()

        println("### INTERSTITIAL ID $interstitialId ")

        InterstitialAd.load(requireContext(),interstitialId, adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                println()
                adError?.toString()?.let { Log.d("INTERSTITIAL ERROR", it) }
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d("SUCCESS INTERSTITIAL", "Ad was loaded")
                mInterstitialAd = interstitialAd
            }
        })
    }

    private fun showInterstitial(){
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(requireActivity())
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.")
        }
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

        questionViewModel.questionList.observe(viewLifecycleOwner) { questions ->

            cardAdapter = CardListAdapter(questions, requireContext())
            viewPager.adapter = cardAdapter

            // Establecer un índice aleatorio
            if (questions.isNotEmpty()) {
                val randomIndex = Random.nextInt(questions.size - 1)
                viewPager.setCurrentItem(randomIndex, false)
            }
        }

        // Configurar el PagerSnapHelper para el centrado
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(null)

        // Opcional: Cambiar la orientación del ViewPager2
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        initInterstitial()

        // Muestra el anuncio interstitial en un evento, por ejemplo, un clic en un botón
        showInterstitial()
    }

    private fun initCardList() {
        questionViewModel.questionList.observe(requireActivity()) { questions ->
            println("### QUESTIONS: $questions")

        }
    }

    private fun initListeners() {
    }


}
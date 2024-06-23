package com.bazan.devquiz.presentation.components

import android.content.Context
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bazan.devquiz.R

class CustomAppBar(
    private val context: Context,
    private var mainLayout: View,
    private val title: String,
    val onGoBackSubmit: () -> Unit,
    private val btnRightIcon: Int = R.drawable.arrow_back,
    private val btnRightColor: Int = R.color.transparent,
    private val onBtnRightSubmit: () -> Unit = { println("# BTN RIGHT PRESSED") },
    private val onlyTitle: Boolean = false,
) {
    private lateinit var titleTxt: TextView
    private lateinit var btnGoBack: ImageButton
    private lateinit var btnRight: ImageButton

    init {
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        titleTxt = mainLayout.findViewById(R.id.txtTitleCustomAppBar)
        btnGoBack = mainLayout.findViewById(R.id.btnGoBackCustomAppBar)
        btnRight = mainLayout.findViewById(R.id.btnRightCustomAppBar)

        btnRight.setImageResource(btnRightIcon)
        btnRight.setColorFilter(ContextCompat.getColor(context, btnRightColor), android.graphics.PorterDuff.Mode.SRC_IN)

        titleTxt.text = title

        if (onlyTitle) {
            btnGoBack.setColorFilter(ContextCompat.getColor(context, R.color.transparent), android.graphics.PorterDuff.Mode.SRC_IN)
            btnRight.setColorFilter(ContextCompat.getColor(context, R.color.transparent), android.graphics.PorterDuff.Mode.SRC_IN)
        }
    }

    private fun initListeners() {
        btnGoBack.setOnClickListener{
            onGoBackSubmit.invoke()
        }

        btnRight.setOnClickListener {
            onBtnRightSubmit.invoke()
        }
    }

    fun setAppBarTitle(title:String) {
        titleTxt.text = title
    }
}
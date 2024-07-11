package com.bazan.devquiz.presentation.pages.topic.components

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import com.bazan.devquiz.R

class DialogDifficulty(
    private val onSubmitBtnOkListener: (id:Int) -> Unit,
    private val dialogLayout: Int,
    private val onSubmitBtnCancelListener: () -> Unit = { println("### NO CANCEL FUNCTION") }
): DialogFragment()  {
    private lateinit var btnEasy: Button
    private lateinit var btnHard: Button
    private lateinit var dialogView: View
    private lateinit var btnClose: ImageButton
    private lateinit var btnIntermediate: Button
    private lateinit var btnCancel: LinearLayout
    private lateinit var inflater: LayoutInflater
    private lateinit var builder: AlertDialog.Builder

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initComponents()
        initListeners()

        builder.setView(dialogView)
        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    private fun initComponents() {
        builder = AlertDialog.Builder(requireActivity())
        inflater = requireActivity().layoutInflater;
        dialogView = inflater.inflate(dialogLayout, null)
        btnEasy = dialogView.findViewById(R.id.btnEasyDifficultyDialog)
        btnIntermediate = dialogView.findViewById(R.id.btnIntermediateDifficultyDialog)
        btnHard = dialogView.findViewById(R.id.btnHardDifficultyDialog)
    }

    private fun initListeners() {
        btnEasy.setOnClickListener{
            onSubmitBtnOkListener.invoke(1)
            dismiss()
        }

        btnIntermediate.setOnClickListener{
            onSubmitBtnOkListener.invoke(2)
            dismiss()
        }

        btnHard.setOnClickListener{
            onSubmitBtnOkListener.invoke(3)
            dismiss()
        }
    }
}
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
    private val onSubmitBtnOkListener: () -> Unit,
    private val dialogLayout: Int,
    private val onSubmitBtnCancelListener: () -> Unit = { println("### NO CANCEL FUNCTION") }
): DialogFragment()  {
    private lateinit var builder: AlertDialog.Builder
    private lateinit var inflater: LayoutInflater
    private lateinit var dialogView: View
    private lateinit var btnContinue: Button
    private lateinit var btnCancel: LinearLayout
    private lateinit var btnClose: ImageButton

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
//        btnContinue = dialogView.findViewById(R.id.btnOkCustomDialog)
//        btnCancel = dialogView.findViewById(R.id.btnCancelCustomDialog)
        btnClose = dialogView.findViewById(R.id.btnCloseCustomDialog)
    }

    private fun initListeners() {
//        btnContinue.setOnClickListener{
//            onSubmitBtnOkListener.invoke()
//            dismiss()
//        }
//
//        btnCancel.setOnClickListener {
//            onSubmitBtnCancelListener.invoke()
//            dismiss()
//        }

        btnClose.setOnClickListener{
            dismiss()
        }
    }
}
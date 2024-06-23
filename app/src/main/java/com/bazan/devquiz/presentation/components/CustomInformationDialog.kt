package com.bazan.devquiz.presentation.components

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.bazan.devquiz.R

class CustomInformationDialog(
    private val onSubmitBtnOkListener: () -> Unit,
    private val dialogLayout: Int,
): DialogFragment()  {
    private lateinit var btnOk: Button
    private lateinit var dialogView: View
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
        btnOk = dialogView.findViewById(R.id.btnOk)
    }

    private fun initListeners() {
        btnOk.setOnClickListener{
            onSubmitBtnOkListener.invoke()
            dismiss()
        }
    }
}
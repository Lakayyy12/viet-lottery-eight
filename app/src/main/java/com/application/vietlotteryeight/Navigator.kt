package com.application.vietlotteryeight

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class Navigator {

    companion object {
        fun showContent(context: Context?, title: String) {
            val dialog = Dialog(context!!)
            dialog.setContentView(R.layout.custom_dialog_content)
            dialog.setCancelable(true)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            val content = dialog.findViewById(R.id.content) as TextView
            val closeDialog = dialog.findViewById(R.id.closeDialog) as ImageView

            closeDialog.setOnClickListener { dialog.dismiss() }
            content.text = title

            dialog.show()

        }

        fun showInfoDialog(context: Context?) {
            val dialog = Dialog(context!!)
            dialog.setContentView(R.layout.custom_dialog_content)
            dialog.setCancelable(true)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val closeDialog = dialog.findViewById(R.id.closeDialog) as ImageView
            closeDialog?.setOnClickListener{dialog.dismiss()}

            dialog.show()

        }

        fun openPage(
            context: Context?,
            className: Class<*>) {

            val intent = Intent(context, className)
            context?.startActivity(intent)
        }

        fun openPage(
            context: Context?,
            className: Class<*>,
            title: String,
            content: String) {

            val intent = Intent(context, className)
            intent.putExtra("title", title)
            intent.putExtra("content", content)
            context?.startActivity(intent)
        }
    }
}
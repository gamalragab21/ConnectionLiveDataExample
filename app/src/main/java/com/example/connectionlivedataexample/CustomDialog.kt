package com.example.connectionlivedataexample

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView

object CustomDialog {
    var dialog2: Dialog? = null
    @SuppressLint("InflateParams")
    fun showHintDialogWifi(context: Activity) {

        dialog2 = Dialog(context)
        dialog2!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog2!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog2!!.window!!.attributes.windowAnimations = R.style.DialogAnimation
        val view: View = LayoutInflater.from(context).inflate(R.layout.dialog_show_internet, null)

        //val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        //titleTextView.text = title
        //val hintTextView = view.findViewById<TextView>(R.id.hintTextView)
        //hintTextView.text = hint

        val continueTextView = view.findViewById<TextView>(R.id.continueTextView)

        continueTextView.setOnClickListener {
            val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
            context.startActivity(intent)
        }
        val closeTextView = view.findViewById<TextView>(R.id.closeTextView)

        closeTextView.text = context.getString(R.string.cancel)

        closeTextView.setOnClickListener {

            dialog2!!.dismiss()

        }

        dialog2!!.setContentView(view)
        dialog2!!.setCancelable(false)
        dialog2!!.setCanceledOnTouchOutside(false)
        try {
            if (!context.isFinishing) {
                if (!dialog2!!.isShowing)
                    dialog2!!.show()
            }
        } catch (e: WindowManager.BadTokenException) {
            e.printStackTrace()
            //use a log message
        }

    }

}
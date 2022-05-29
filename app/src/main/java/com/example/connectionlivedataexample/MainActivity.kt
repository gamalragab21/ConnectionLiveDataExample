package com.example.connectionlivedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvConnection: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvConnection=findViewById(R.id.tv_connection)
        ConnectionLiveData(this).observe(this) {
            if (!it) {
                CustomDialog.showHintDialogWifi(this)
                tvConnection.text="Disconnected"
            }else{
                tvConnection.text="Connected"
                CustomDialog.dialog2?.dismiss()
            }
        }
    }
}
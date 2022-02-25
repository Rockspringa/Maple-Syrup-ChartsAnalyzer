package edu.mooncoder.syrupcharts.design.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico
import edu.mooncoder.syrupcharts.R
import edu.mooncoder.syrupcharts.controller.ChartifyCode

const val SLICE_ACTIVITY = "edu.mooncoder.syrupcharts.ui.SlideActivity"

class MainActivity : AppCompatActivity() {
    private var codeInput: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        codeInput = findViewById(R.id.code_input)
    }

    fun openSliceActivity(view: View) {
        val chartifyCode = ChartifyCode(codeInput!!.text)

        if (chartifyCode.charts is List<Grafico>) {
            val intent = Intent(this, SlideActivity()::class.java)
            startActivity(intent)
        } else {
            LogActivity.errors = chartifyCode.errors
            val intent = Intent(this, LogActivity()::class.java)
            startActivity(intent)
        }

    }
}
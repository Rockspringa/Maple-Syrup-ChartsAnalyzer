package edu.mooncoder.syrupcharts.design.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.mooncoder.mapleanalyzer.model.wrappers.ErrorHolder
import edu.mooncoder.syrupcharts.R

class LogActivity() : AppCompatActivity() {
    companion object {
        var errors: Array<ErrorHolder>? = null
    }

    private lateinit var log: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        log = findViewById(R.id.errors_log)
        log.text = ""
        errors!!.forEachIndexed { i, error -> log.text = "${log.text}${i + 1}: $error\n\n" }
    }
}
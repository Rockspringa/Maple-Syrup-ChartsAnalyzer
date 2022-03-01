package edu.mooncoder.syrupcharts.design.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.mooncoder.mapleanalyzer.model.wrappers.ErrorHolder
import edu.mooncoder.mapleanalyzer.model.wrappers.Reporte
import edu.mooncoder.syrupcharts.R
import edu.mooncoder.syrupcharts.controller.TableRowsCreator

class LogActivity() : AppCompatActivity() {
    private lateinit var log: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        addErrors(Reporte.getReporte(), layoutInflater)
    }

    private fun addErrors(report: Reporte, inflater: LayoutInflater) {
        val tableErrors: TableLayout = findViewById(R.id.error_table)
        val tableRowsCreator = TableRowsCreator(report, inflater, null)

        tableRowsCreator.getRowsError().forEachIndexed { i, row -> tableErrors.addView(row, i + 1) }
    }
}
package edu.mooncoder.syrupcharts.controller

import android.text.Editable
import androidx.fragment.app.Fragment
import edu.mooncoder.mapleanalyzer.controller.Interpretator
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico
import edu.mooncoder.syrupcharts.design.fragments.ChartsFragment
import edu.mooncoder.syrupcharts.design.fragments.ReportFragment

class ChartifyCode(editable: Editable) {
    private var interpreter: Interpretator? = null
    var charts: List<Grafico>? = null

    companion object {
        private lateinit var instance: ChartifyCode

        fun getChartsView() : Fragment {
            return ChartsFragment(instance.charts!!)
        }

        fun getReportView() : Fragment {
            return ReportFragment()
        }
    }

    init {
        instance = this
        interpreter = Interpretator(editable.toString())
        charts = if (!hasErrors())
            interpreter!!.colaEjecucion
        else
            null
    }

    fun hasErrors(): Boolean {
        return interpreter!!.hasErrors()
    }
}
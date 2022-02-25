package edu.mooncoder.syrupcharts.controller

import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import edu.mooncoder.mapleanalyzer.controller.Interpretator
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico
import edu.mooncoder.mapleanalyzer.model.wrappers.ErrorHolder
import edu.mooncoder.syrupcharts.design.activities.LogActivity
import edu.mooncoder.syrupcharts.design.activities.SlideActivity
import edu.mooncoder.syrupcharts.design.fragments.ChartsFragment

class ChartifyCode(editable: Editable) {
    private var interpreter: Interpretator? = null
    var errors: Array<ErrorHolder>? = null
    var charts: List<Grafico>? = null

    companion object {
        private lateinit var instance: ChartifyCode

        fun getChartsView() : Fragment {
            return ChartsFragment(instance)
        }
    }

    init {
        instance = this
        interpreter = Interpretator(editable.toString())
        errors = interpreter!!.errores
        charts = if (errors!!.isEmpty())
            interpreter!!.colaEjecucion
        else
            null
    }
}
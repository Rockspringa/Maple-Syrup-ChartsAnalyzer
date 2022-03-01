package edu.mooncoder.syrupcharts.design.adapters.chartviewholders

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico
import edu.mooncoder.mapleanalyzer.model.contracts.Tipo
import edu.mooncoder.mapleanalyzer.model.graficos.GraficoPie
import edu.mooncoder.syrupcharts.R
import edu.mooncoder.syrupcharts.design.adapters.ChartViewHolder
import java.util.ArrayList

class PieChartViewHolder(view: View, private val context: Context) : ChartViewHolder(view) {
    private val pieChartView: PieChart = view.findViewById(R.id.pie_chart_layout)
    private val pieChartTitle: TextView = view.findViewById(R.id.pie_chart_title)

    companion object {
        fun isValuesOverflow(chart: Grafico): Boolean {
            val pieChart = chart as GraficoPie
            var restValue = pieChart.total

            pieChart.unir.forEach { tupla -> restValue -= pieChart.valores[tupla.y].toFloat() }

            return restValue >= 0
        }
    }

    override fun bind(chart: Grafico) {
        val pieChart = chart as GraficoPie

        val entries: ArrayList<PieEntry> = ArrayList()
        val label = ""

        pieChartTitle.text = pieChart.titulo

        pieChart.unir.forEach { tupla ->
            val tag = pieChart.etiquetas[tupla.x]
            val value = pieChart.valores[tupla.y].toFloat()
            entries.add(PieEntry(value, tag))
        }
        addRest(pieChart, entries)

        val pieDataSet = PieDataSet(entries, label)
        val pieData = PieData(pieDataSet)

        makeDesign(pieChart, pieDataSet, pieData)

        pieChartView.data = pieData
        pieChartView.invalidate()
    }

    private fun makeDesign(pieChart: GraficoPie, pieDataSet: PieDataSet, pieData: PieData) {
        pieDataSet.valueTextSize = 12f
        pieDataSet.colors = ColorTemplate.COLORFUL_COLORS.asList()


        pieData.setDrawValues(true)
        pieChartView.holeRadius = 0f
        pieChartView.legend.textColor = ContextCompat.getColor(context, R.color.purple_200)

        if (pieChart.tipo == Tipo.PORCENTAJE)
            pieData.setValueFormatter(PercentFormatter())
    }

    private fun addRest(pieChart: GraficoPie, entries: ArrayList<PieEntry>) {
        var restValue = pieChart.total

        pieChart.unir.forEach { tupla -> restValue -= pieChart.valores[tupla.y].toFloat() }

        if (restValue > 0) {
            entries.add(PieEntry(restValue.toFloat(), pieChart.extra))
        } else if (restValue < 0) {
            throw NegativeArraySizeException("El total es menor a la suma de los valores.")
        }
    }
}
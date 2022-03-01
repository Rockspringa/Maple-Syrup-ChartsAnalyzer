package edu.mooncoder.syrupcharts.design.adapters.chartviewholders

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico
import edu.mooncoder.mapleanalyzer.model.graficos.GraficoBarras
import edu.mooncoder.syrupcharts.R
import edu.mooncoder.syrupcharts.design.adapters.ChartViewHolder
import java.util.ArrayList

class BarChartViewHolder(view: View, private val context: Context) : ChartViewHolder(view) {
    private val barChartView: BarChart = view.findViewById(R.id.bar_chart_layout)
    private val barChartTitle: TextView = view.findViewById(R.id.bar_chart_title)

    override fun bind(chart: Grafico) {
        val barChart = chart as GraficoBarras

        val entries: ArrayList<BarEntry> = ArrayList()
        val title = barChart.titulo
        barChartTitle.text = barChart.titulo

        barChart.unir.forEach { tupla ->
            val index = tupla.x.toFloat()
            val value = barChart.ejeY[tupla.y].toFloat()
            entries.add(BarEntry(index, value))
        }

        val barDataSet = BarDataSet(entries, title)
        barChartView.data = BarData(barDataSet)

        makeDesign(barChart, barDataSet)

        barChartView.invalidate()
    }

    private fun makeDesign(barChart: GraficoBarras, barDataSet: BarDataSet) {
        val xAxis = barChartView.xAxis

        xAxis.textColor = 1
        xAxis.position = XAxis.XAxisPosition.BOTTOM;
        xAxis.granularity = 1f

        xAxis.valueFormatter = XAxisValueFormatter(barChart)
        xAxis.textColor = ContextCompat.getColor(context, R.color.purple_200)

        xAxis.setDrawGridLines(false);

        barChartView.axisLeft.textColor = ContextCompat.getColor(context, R.color.purple_200)
        barDataSet.colors = ColorTemplate.COLORFUL_COLORS.asList()
    }
}

private class XAxisValueFormatter(private val barChart: GraficoBarras) : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        return barChart.ejeX[value.toInt()]
    }
}
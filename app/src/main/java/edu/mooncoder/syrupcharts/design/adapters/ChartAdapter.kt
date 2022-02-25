package edu.mooncoder.syrupcharts.design.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico
import edu.mooncoder.mapleanalyzer.model.contracts.Tipo
import edu.mooncoder.mapleanalyzer.model.graficos.GraficoBarras
import edu.mooncoder.mapleanalyzer.model.graficos.GraficoPie
import edu.mooncoder.syrupcharts.R
import java.util.*


class ChartAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var charts = listOf<Grafico>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = if (charts.isNotEmpty()) charts.size else 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            -1 -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.no_charts_resource, parent, false)

                return NoChartViewHolder(view)
            }
            0 -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.bar_chart_resource, parent, false)

                return BarChartViewHolder(view, view.context)
            }
            else -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.pie_chart_resources, parent, false)

                return PieChartViewHolder(view, view.context)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder !is NoChartViewHolder && holder is ChartViewHolder) {
            val chart = charts[position]
            holder.bind(chart)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            charts.isEmpty() -> -1
            charts[position] is GraficoBarras -> 0
            else -> 1
        }
    }
}

private abstract class ChartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(chart: Grafico)
}

private class NoChartViewHolder(view: View) : ChartViewHolder(view) {
    override fun bind(chart: Grafico) = Unit
}

private class BarChartViewHolder(view: View, private val context: Context) : ChartViewHolder(view) {
    val barChartView: BarChart = view.findViewById(R.id.bar_chart_layout)
    val barChartTitle: TextView = view.findViewById(R.id.bar_chart_title)

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
        barDataSet.colors = ColorTemplate.COLORFUL_COLORS.asList()

        barChartView.data = BarData(barDataSet)


        val xAxis = barChartView.xAxis
        xAxis.textColor = 1
        xAxis.position = XAxis.XAxisPosition.BOTTOM;
        xAxis.setDrawGridLines(false);
        xAxis.granularity = 1f
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return barChart.ejeX[value.toInt()]
            }
        }

        xAxis.textColor = getColor(context, R.color.purple_200)
        barChartView.axisLeft.textColor = getColor(context, R.color.purple_200)

        barChartView.invalidate()
    }
}

private class PieChartViewHolder(view: View, private val context: Context) : ChartViewHolder(view) {
    val pieChartView: PieChart = view.findViewById(R.id.pie_chart_layout)
    val pieChartTitle: TextView = view.findViewById(R.id.pie_chart_title)

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
        pieDataSet.valueTextSize = 12f
        pieDataSet.colors = ColorTemplate.COLORFUL_COLORS.asList()


        val pieData = PieData(pieDataSet)
        pieData.setDrawValues(true)
        pieChartView.holeRadius = 0f
        pieChartView.legend.textColor = getColor(context, R.color.purple_200)

        if (pieChart.tipo == Tipo.PORCENTAJE)
            pieData.setValueFormatter(PercentFormatter())

        pieChartView.data = pieData
        pieChartView.invalidate()
    }

    private fun addRest(pieChart: GraficoPie, entries: ArrayList<PieEntry>) {
        var restValue = pieChart.total
        pieChart.valores.forEach { value -> restValue -= value }
        if (restValue > 0) {
            entries.add(PieEntry(restValue.toFloat(), pieChart.extra))
        } else if (restValue < 0) {
            throw NegativeArraySizeException("El total es menor a la suma de los valores.")
        }
    }
}
package edu.mooncoder.syrupcharts.design.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico
import edu.mooncoder.mapleanalyzer.model.graficos.GraficoBarras
import edu.mooncoder.mapleanalyzer.model.graficos.GraficoPie
import edu.mooncoder.syrupcharts.R
import edu.mooncoder.syrupcharts.design.adapters.chartviewholders.BarChartViewHolder
import edu.mooncoder.syrupcharts.design.adapters.chartviewholders.NoChartViewHolder
import edu.mooncoder.syrupcharts.design.adapters.chartviewholders.PieChartViewHolder


class ChartAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var charts = listOf<Grafico>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = if (charts.isNotEmpty()) charts.size else 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.no_charts_resource, parent, false)

                return NoChartViewHolder(view)
            }
            1 -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.bar_chart_resource, parent, false)

                return BarChartViewHolder(view, view.context)
            }
            2 -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.pie_chart_resources, parent, false)

                return PieChartViewHolder(view, view.context)
            }
            else -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.no_charts_resource, parent, false)

                return NoChartViewHolder(view).changeToOverflow()
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
            charts.isEmpty() -> 0
            charts[position] is GraficoBarras -> 1
            charts[position] is GraficoPie && PieChartViewHolder.isValuesOverflow((charts[position])) -> 2
            else -> 3
        }
    }
}
package edu.mooncoder.syrupcharts.design.adapters.chartviewholders

import android.view.View
import android.widget.ImageView
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico
import edu.mooncoder.syrupcharts.R
import edu.mooncoder.syrupcharts.design.adapters.ChartViewHolder

class NoChartViewHolder(view: View) : ChartViewHolder(view) {
    private val noChartView: ImageView = view.findViewById(R.id.no_chart_view)

    override fun bind(chart: Grafico) = Unit

    fun changeToOverflow(): NoChartViewHolder {
        noChartView.setImageResource(R.mipmap.overflow_foreground)
        return this
    }
}
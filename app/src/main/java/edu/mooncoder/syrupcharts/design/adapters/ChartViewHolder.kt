package edu.mooncoder.syrupcharts.design.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico

abstract class ChartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(chart: Grafico)
}
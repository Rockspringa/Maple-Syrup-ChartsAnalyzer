package edu.mooncoder.syrupcharts.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import edu.mooncoder.mapleanalyzer.model.wrappers.ErrorHolder
import edu.mooncoder.mapleanalyzer.model.wrappers.OcurrenciaMatematica
import edu.mooncoder.mapleanalyzer.model.wrappers.Reporte
import edu.mooncoder.syrupcharts.R

class TableRowsCreator(
    private val report: Reporte,
    private val inflater: LayoutInflater,
    private val container: ViewGroup?
) {
    fun getRowsMath(): List<View> {
        val rows: MutableList<View> = mutableListOf()

        if (report.ocurrenciasMatematicas.isEmpty()) {
            rows += getEmptyMathRowView()
        } else {
            report.ocurrenciasMatematicas.forEach { math -> rows += getMathRowView(math) }
        }
        return rows
    }

    fun getRowsError(): List<View> {
        val rows: MutableList<View> = mutableListOf()

        if (report.errores.isEmpty()) {
            rows += getEmptyErrorRowView()
        } else {
            report.errores.forEach { error -> rows += getErrorRowView(error) }
        }
        return rows
    }

    private fun getMathRowView(data: OcurrenciaMatematica): TableRow {
        val row: TableRow = inflater.inflate(R.layout.row_resource, container, false) as TableRow

        val operator: TextView = row.findViewById(R.id.operator)
        val line: TextView = row.findViewById(R.id.line)
        val column: TextView = row.findViewById(R.id.column)

        operator.text = data.operador.toString()
        line.text = data.line.toString()
        column.text = data.column.toString()

        return row
    }

    private fun getEmptyMathRowView(): TableRow {
        val row: TableRow = inflater.inflate(R.layout.row_resource, container, false) as TableRow

        val operator: TextView = row.findViewById(R.id.operator)
        val line: TextView = row.findViewById(R.id.line)
        val column: TextView = row.findViewById(R.id.column)

        operator.text = "No hay"
        line.text = "ninguna"
        column.text = "operacion."

        return row
    }

    private fun getErrorRowView(data: ErrorHolder): TableRow {
        val row: TableRow = inflater.inflate(R.layout.error_row_resource, container, false) as TableRow

        val line: TextView = row.findViewById(R.id.line_error)
        val column: TextView = row.findViewById(R.id.column_error)
        val type: TextView = row.findViewById(R.id.type_error)
        val description: TextView = row.findViewById(R.id.description_error)

        line.text = data.line.toString()
        column.text = data.column.toString()
        type.text = data.fase.toString()
        description.text = data.message.toString()

        return row
    }

    private fun getEmptyErrorRowView(): TableRow {
        val row: TableRow = inflater.inflate(R.layout.error_row_resource, container, false) as TableRow

        val line: TextView = row.findViewById(R.id.line_error)
        val column: TextView = row.findViewById(R.id.column_error)
        val type: TextView = row.findViewById(R.id.type_error)
        val description: TextView = row.findViewById(R.id.description_error)

        line.text = "No"
        column.text = "hay"
        type.text = "ningun"
        description.text = "error."

        return row
    }
}
package edu.mooncoder.syrupcharts.design.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView
import edu.mooncoder.mapleanalyzer.model.wrappers.Reporte
import edu.mooncoder.syrupcharts.R
import edu.mooncoder.syrupcharts.controller.TableRowsCreator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReportFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReportFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_report, container, false)
        val report = Reporte.getReporte()

        addMaths(view, report, inflater, container)
        setValuesOfCharts(view, report)

        return view
    }

    private fun addMaths(view: View, report: Reporte, inflater: LayoutInflater, container: ViewGroup?) {
        val tableMath: TableLayout = view.findViewById(R.id.report_math)
        val tableRowsCreator = TableRowsCreator(report, inflater, container)

        tableRowsCreator.getRowsMath().forEachIndexed { i, row -> tableMath.addView(row, i + 1) }
    }

    private fun setValuesOfCharts(view: View, report: Reporte) {
        val barsCant: TextView = view.findViewById(R.id.bars_cant)
        val piesCant: TextView = view.findViewById(R.id.pies_cant)

        barsCant.text = report.barsDefinidos.toString()
        piesCant.text = report.piesDefinidos.toString()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ReportFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReportFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
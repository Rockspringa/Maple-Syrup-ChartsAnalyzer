package edu.mooncoder.syrupcharts.design.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico
import edu.mooncoder.syrupcharts.R
import edu.mooncoder.syrupcharts.design.adapters.ChartAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChartsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChartsFragment(private val charts: List<Grafico>) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var chartsList: RecyclerView? = null

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
        val view: View = inflater.inflate(R.layout.fragment_charts, container, false)

        chartsList = view.findViewById(R.id.chart_list)

        val chartAdapter = ChartAdapter()
        chartAdapter.charts = charts

        chartsList?.adapter = chartAdapter

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChartsActivity.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(
            param1: String,
            param2: String,
            charts: List<Grafico>
        ): ChartsFragment {
            return ChartsFragment(charts).apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        }
    }
}
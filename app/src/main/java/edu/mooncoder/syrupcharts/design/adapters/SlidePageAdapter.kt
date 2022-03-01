package edu.mooncoder.syrupcharts.design.adapters

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import edu.mooncoder.syrupcharts.controller.ChartifyCode
import edu.mooncoder.syrupcharts.design.activities.NUM_PAGES

class SlidePageAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> ChartifyCode.getChartsView()
        else -> ChartifyCode.getReportView()
    }
}
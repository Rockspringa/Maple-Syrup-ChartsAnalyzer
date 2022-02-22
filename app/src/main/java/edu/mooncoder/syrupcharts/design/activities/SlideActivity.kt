package edu.mooncoder.syrupcharts.design.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import edu.mooncoder.syrupcharts.R
import edu.mooncoder.syrupcharts.design.fragments.ChartsFragment
import edu.mooncoder.syrupcharts.design.fragments.CodeFragment

const val NUM_PAGES = 3

class SlideActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private var tabNames = arrayOf("Codigo", "Reporte", "Graficas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)

        viewPager = findViewById(R.id.pager)

        val pagerAdapter = SlidePageAdapter(this)
        viewPager.adapter = pagerAdapter

        tabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> tabNames[0]
                1 -> tabNames[1]
                else -> tabNames[tabNames.size - 1]
            }
        }.attach()
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    private inner class SlidePageAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> CodeFragment()
            else -> ChartsFragment()
        }
    }
}
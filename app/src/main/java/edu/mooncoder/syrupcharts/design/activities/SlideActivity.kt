package edu.mooncoder.syrupcharts.design.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import edu.mooncoder.syrupcharts.R
import edu.mooncoder.syrupcharts.design.adapters.SlidePageAdapter

const val NUM_PAGES = 2

class SlideActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private var tabNames = arrayOf("Graficas", "Reporte")

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
}
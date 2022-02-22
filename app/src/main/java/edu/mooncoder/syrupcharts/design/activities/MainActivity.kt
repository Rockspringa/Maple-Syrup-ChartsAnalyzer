package edu.mooncoder.syrupcharts.design.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import edu.mooncoder.syrupcharts.R

const val SLICE_ACTIVITY = "edu.mooncoder.syrupcharts.ui.SlideActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openSliceActivity(view: View) {
        val intent = Intent(this, SlideActivity::class.java)
        startActivity(intent)
    }
}
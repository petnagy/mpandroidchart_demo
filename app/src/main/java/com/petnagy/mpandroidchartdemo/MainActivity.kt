package com.petnagy.mpandroidchartdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.petnagy.mpandroidchartdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val dataSet: MutableList<Int> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonGenerate.setOnClickListener {
            dataSet.clear()
            for (x in 1..100) {
                dataSet.add((-10..100).random())
            }
            showChart()
        }
    }

    private fun showChart() {
        val chart = binding.chart
        chart.removeAllViews()

        val chartData = dataSet.mapIndexed { index, value ->
            Entry(index.toFloat(), value.toFloat())
        }

        val chartDataSet = LineDataSet(chartData, "data")
        val data = LineData(chartDataSet)
        chart.data = data

        chart.notifyDataSetChanged()
    }
}

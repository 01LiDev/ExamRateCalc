package com.example.examratecalc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class BarGraph : AppCompatActivity() {
    private lateinit var barChart: BarChart

    // on below line we are creating
    // a variable for bar data
    private lateinit var barData: BarData

    // on below line we are creating a
    // variable for bar data set
    private lateinit var barDataSet: BarDataSet

    private var rates = arrayOf("A%", "B%", "C%", "D%", "F%")
    // on below line we are creating array list for bar data
    private lateinit var barEntriesList: ArrayList<BarEntry>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_graph)
        barChart = findViewById(R.id.idBarChart)

        // on below line we are calling get bar
        // chart data to add data to our array list
        getBarChartData()

        // on below line we are initializing our bar data set
        barDataSet = BarDataSet(barEntriesList, "Student Grade Tier Rates")

        // on below line we are initializing our bar data
        barData = BarData(barDataSet)

        // on below line we are setting data to our bar chart
        barChart.data = barData

        // on below line we are setting colors for our bar chart text
        barDataSet.valueTextColor = Color.BLACK

        // on below line we are setting color for our bar data set
        barDataSet.color = resources.getColor(R.color.purple_200)

        // on below line we are setting text size
        barDataSet.valueTextSize = 16f

        // on below line we are enabling description as false
        barChart.description.isEnabled = false

        val xAxis = barChart.xAxis

        // below line is to set value formatter to our x-axis and
        // we are adding our days to our x axis.
        xAxis.valueFormatter = IndexAxisValueFormatter(rates)

        // below line is to set center axis
        // labels to our bar chart.
        xAxis.setCenterAxisLabels(true)

        // below line is to set position
        // to our x-axis to bottom.
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        // below line is to set granularity
        // to our x axis labels.
        xAxis.granularity = 1f

        // below line is to enable
        // granularity to our x axis.
        xAxis.isGranularityEnabled = true


        // below line is to set minimum
        // axis to our chart.
        barChart.xAxis.axisMinimum = 0f

        // below line is to
        // animate our chart.
        barChart.animate()

        // below line is to group bars
        // and add spacing to it.


    }

    private fun getBarChartData() {
        barEntriesList = ArrayList()

        // on below line we are adding data
        // to our bar entries list
        barEntriesList.add(BarEntry(1f, aRate))
        barEntriesList.add(BarEntry(2f, bRate))
        barEntriesList.add(BarEntry(3f, cRate))
        barEntriesList.add(BarEntry(4f, dRate))
        barEntriesList.add(BarEntry(5f, fRate))
    }
}
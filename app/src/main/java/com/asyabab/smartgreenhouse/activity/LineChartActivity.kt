package com.asyabab.smartgreenhouse.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.asyabab.smartgreenhouse.R
import com.github.mikephil.charting.components.IMarker
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_line_chart.*

class LineChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_chart)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Konfigurasi Line Chart
        lineChart.description.isEnabled = false
//        lineChart.setDrawGridBackground(false)
//        lineChart.setDrawBorders(false)
//        lineChart.getAxisLeft().setEnabled(false)
//        lineChart.getAxisRight().setDrawAxisLine(false)
//        lineChart.getAxisRight().setDrawGridLines(false)
//        lineChart.getXAxis().setDrawAxisLine(false)
//        lineChart.getXAxis().setDrawGridLines(false)
//        lineChart.setTouchEnabled(true) // enable touch gestures. Allows to enable/disable all possible touch-interactions with the chart.
//        lineChart.setDragEnabled(true) // enable scaling and dragging
//        lineChart.setScaleEnabled(true) //Enables/disables scaling for the chart on both axes.
//        lineChart.setScaleXEnabled(true) //Enables/disables scaling on the x-axis and y-axis
//        lineChart.setPinchZoom(false) // if disabled, scaling can be done on x- and y-axis can be zoomed separately
//        lineChart.axisLeft.isEnabled = false
//        lineChart.axisLeft.spaceTop = 40f
//        lineChart.axisLeft.spaceBottom = 40f
//        lineChart.axisRight.isEnabled = false
//        lineChart.xAxis.isEnabled = true
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
//        lineChart.xAxis.setDrawGridLines(true);
//        lineChart.xAxis.granularity = 1f;

        //Setting Legend
        val legend = lineChart.legend
        legend.isEnabled = true
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        legend.orientation = Legend.LegendOrientation.HORIZONTAL
        legend.setDrawInside(false)

        val kasus = ArrayList<Entry>()
        kasus.add(Entry(0F, 149F))
        kasus.add(Entry(1F, 113F))
        kasus.add(Entry(2F, 196F))
        kasus.add(Entry(3F, 106F))
        kasus.add(Entry(4F, 181F))
        kasus.add(Entry(5F, 218F))
        kasus.add(Entry(6F, 247F))
        kasus.add(Entry(7F, 218F))
        kasus.add(Entry(8F, 337F))
        kasus.add(Entry(9F, 219F))

        val sembuh = ArrayList<Entry>()
        sembuh.add(Entry(0F, 22F))
        sembuh.add(Entry(1F, 9F))
        sembuh.add(Entry(2F, 22F))
        sembuh.add(Entry(3F, 16F))
        sembuh.add(Entry(4F, 14F))
        sembuh.add(Entry(5F, 28F))
        sembuh.add(Entry(6F, 12F))
        sembuh.add(Entry(7F, 18F))
        sembuh.add(Entry(8F, 30F))
        sembuh.add(Entry(9F, 30F))

        val meninggal = ArrayList<Entry>()
        meninggal.add(Entry(0F, 21F))
        meninggal.add(Entry(1F, 13F))
        meninggal.add(Entry(2F, 11F))
        meninggal.add(Entry(3F, 10F))
        meninggal.add(Entry(4F, 7F))
        meninggal.add(Entry(5F, 11F))
        meninggal.add(Entry(6F, 12F))
        meninggal.add(Entry(7F, 19F))
        meninggal.add(Entry(8F, 40F))
        meninggal.add(Entry(9F, 26F))

        val kasusLineDataSet = LineDataSet(kasus, "Kasus")
        kasusLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        kasusLineDataSet.color = Color.BLUE
        kasusLineDataSet.circleRadius = 5f
        kasusLineDataSet.setCircleColor(Color.BLUE)

        val sembuhLineDataSet = LineDataSet(sembuh, "Sembuh")
        sembuhLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        sembuhLineDataSet.color = Color.GREEN
        sembuhLineDataSet.circleRadius = 5f
        sembuhLineDataSet.setCircleColor(Color.GREEN)

        val meninggalLineDataSet = LineDataSet(meninggal, "Meninggal")
        meninggalLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        meninggalLineDataSet.color = Color.RED
        meninggalLineDataSet.circleRadius = 5f
        meninggalLineDataSet.setCircleColor(Color.RED)

        var date = ArrayList<String>();
        date.add("01-Apr")
        date.add("02-Apr")
        date.add("03-Apr")
        date.add("04-Apr")
        date.add("05-Apr")
        date.add("06-Apr")
        date.add("07-Apr")
        date.add("08-Apr")
        date.add("09-Apr")
        date.add("10-Apr")
        val tanggal = AxisDateFormatter(date.toArray(arrayOfNulls<String>(date.size)))
        lineChart.xAxis?.setValueFormatter(tanggal);

        val marker : IMarker = LineChartMarkerView(applicationContext, lineChart, R.layout.markerview_three_item, tanggal);
        lineChart.marker = marker;

        lineChart.data = LineData(kasusLineDataSet, sembuhLineDataSet, meninggalLineDataSet)
        lineChart.animateXY(100, 500)
    }

//    private fun getLineData() : LineData?{
//        val data: ArrayList<Entry> = ArrayList();
//    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home ->{
                super.onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

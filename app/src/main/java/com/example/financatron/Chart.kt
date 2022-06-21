package com.example.financatron

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.textfield.TextInputEditText

class Chart : AppCompatActivity() {

    private lateinit var barList: ArrayList<BarEntry>
    private lateinit var barDataSet: BarDataSet
    private lateinit var barData: BarData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        chart()
        getDay(R.id.btnSunday, 0, 1f)
        getDay(R.id.btnMonday, 1, 2f)
        getDay(R.id.btnTuesday, 2, 3f)
        getDay(R.id.btnWednesday, 3, 4f)
        getDay(R.id.btnThursday, 4, 5f)
        getDay(R.id.btnFriday, 5, 6f)
        getDay(R.id.btnSaturday, 6, 7f)


        val button = findViewById<Button>(R.id.btnTotal)
        button.setOnClickListener {
            val intent = Intent(this, Total::class.java)
            startActivity(intent)
        }

    }


    private fun chart() {
        val barChart = findViewById<BarChart>(R.id.barChart)

        barList = ArrayList()
        barList.add(BarEntry(1f, 500f))
        barList.add(BarEntry(2f, 600f))
        barList.add(BarEntry(3f, 100f))
        barList.add(BarEntry(4f, 300f))
        barList.add(BarEntry(5f, 800f))
        barList.add(BarEntry(6f, 400f))
        barList.add(BarEntry(7f, 200f))

        barDataSet = BarDataSet(barList, "Gastos")
        barData = BarData(barDataSet)
        barChart.data = barData

        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS, 250)
        barDataSet.valueTextColor = Color.WHITE
        barDataSet.valueTextSize = 15f
    }

    private fun getPrice(): Float? {
        return findViewById<TextInputEditText>(R.id.productPriceInput).text.toString().toFloatOrNull()
    }

    private fun getProduct(): String {
        return findViewById<TextInputEditText>(R.id.productInput).text.toString()
    }

    private fun getDay(day: Int, index: Int, x: Float) {
        val btn = findViewById<Button>(day)
        val inputPrice = findViewById<TextInputEditText>(R.id.productPriceInput)

        val dayName = when (day) {
            R.id.btnSunday -> "Domingo"
            R.id.btnMonday -> "Segunda"
            R.id.btnTuesday -> "Terça"
            R.id.btnWednesday -> "Quarta"
            R.id.btnThursday -> "Quinta"
            R.id.btnFriday -> "Sexta"
            R.id.btnSaturday -> "Sábado"
            else -> ""
        }

        btn.setOnClickListener() {
            inputPrice.setOnEditorActionListener() { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    val text = v.text.toString().toFloatOrNull()
                    barList[index] = BarEntry(x, text ?: 0f)
                    true
                } else {
                    false
                }
            }
            findViewById<TextView>(R.id.selectedDay).apply {
                text = dayName
            }
        }
    }

}
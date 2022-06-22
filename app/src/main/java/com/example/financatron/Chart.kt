package com.example.financatron

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.financatron.product.Product
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.textfield.TextInputEditText

class Chart : AppCompatActivity() {

    private lateinit var barList: ArrayList<BarEntry>
    private lateinit var barDataSet: BarDataSet
    private lateinit var barData: BarData

    private lateinit var userName: String
    private lateinit var userProducts: List<Product>
    private lateinit var userWeek: ArrayList<Day>

    private lateinit var productNameInput: TextInputEditText
    private lateinit var productPriceInput: TextInputEditText
    private lateinit var productDayInput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        productNameInput = findViewById(R.id.productInput)
        productPriceInput = findViewById(R.id.productPriceInput)
        productDayInput = findViewById(R.id.selectedDay)
        userProducts = ArrayList()

        getDay(R.id.btnSunday)
        getDay(R.id.btnMonday)
        getDay(R.id.btnTuesday)
        getDay(R.id.btnWednesday)
        getDay(R.id.btnThursday)
        getDay(R.id.btnFriday)
        getDay(R.id.btnSaturday)

        val logoutButton = findViewById<Button>(R.id.btnLogout)
        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        userName = intent.getStringExtra("Username").toString()
        findViewById<TextView>(R.id.helloName).apply {
            text = userName
        }

        val saveButton = findViewById<Button>(R.id.btnSave)
        saveButton.setOnClickListener {
            val productName = productNameInput.text.toString()
            val productPrice = productPriceInput.text.toString()
            val productDay = productDayInput.text.toString()
            DataModel.instance.addProduct(
                Product(
                    name = productName,
                    price = productPrice.toFloat(),
                    day = productDay,
                    userName = userName
                )
            )
            updateUserProducts()
            println(userProducts)
        }

        loadDays()
        chart()
        updateUserProducts()

        val totalButton = findViewById<Button>(R.id.btnTotal)
        totalButton.setOnClickListener {
            val intent = Intent(this, Total::class.java)
            intent.putExtra("Username", userName)
            startActivity(intent)
        }
    }

    private fun updateUserProducts() {
        userProducts = DataModel.instance.getAllProducts(userName)
        loadDays()
        chart()
    }

    private fun loadDays() {
        userWeek = ArrayList()
        userWeek.add(Day(name = "Domingo", expenses = 0f))
        userWeek.add(Day(name = "Segunda", expenses = 0f))
        userWeek.add(Day(name = "Terça", expenses = 0f))
        userWeek.add(Day(name = "Quarta", expenses = 0f))
        userWeek.add(Day(name = "Quinta", expenses = 0f))
        userWeek.add(Day(name = "Sexta", expenses = 0f))
        userWeek.add(Day(name = "Sábado", expenses = 0f))

        for (product in userProducts) {
            val day = userWeek.find { product.day == it.name }
            if (day != null) {
                day.expenses += product.price
            }
        }

        println(userWeek)
    }

    private fun chart() {
        val barChart = findViewById<BarChart>(R.id.barChart)

        barList = ArrayList()
        barList.add(BarEntry(1f, userWeek[0].expenses))
        barList.add(BarEntry(2f, userWeek[1].expenses))
        barList.add(BarEntry(3f, userWeek[2].expenses))
        barList.add(BarEntry(4f, userWeek[3].expenses))
        barList.add(BarEntry(5f, userWeek[4].expenses))
        barList.add(BarEntry(6f, userWeek[5].expenses))
        barList.add(BarEntry(7f, userWeek[6].expenses))

        barDataSet = BarDataSet(barList, "Gastos")
        barData = BarData(barDataSet)
        barChart.data = barData

        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS, 250)
        barDataSet.valueTextColor = Color.WHITE
        barDataSet.valueTextSize = 15f
        barChart.notifyDataSetChanged()
        barChart.invalidate()
    }

    private fun getDay(day: Int) {
        val btn = findViewById<Button>(day)

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
            findViewById<TextView>(R.id.selectedDay).apply {
                text = dayName
            }
        }
    }

}
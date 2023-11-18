package com.example.gipolanactivity6

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar


class Activity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_6)
        val alertDialogButton = findViewById<Button>(R.id.btnAlertDialog)
        val datePickerButton = findViewById<Button>(R.id.btnDatePicker)
        val timePickerButton = findViewById<Button>(R.id.btnTimePicker)
        alertDialogButton.setOnClickListener { showAlertDialog() }
        datePickerButton.setOnClickListener { showDatePickerDialog() }
        timePickerButton.setOnClickListener { showTimePickerDialog() }
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Did you know that spiders are great web designers?")
            .setPositiveButton(
                "OK"
            ) { dialog: DialogInterface?, which: Int ->
                showToast(
                    "OK clicked"
                )
            }
            .setNegativeButton(
                "Cancel"
            ) { dialog: DialogInterface?, which: Int ->
                showToast(
                    "Cancel clicked"
                )
            }
        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DAY_OF_MONTH]
        val datePickerDialog = DatePickerDialog(this,
            { view, selectedYear, selectedMonth, selectedDay -> showToast("Selected Date: " + selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay) },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar[Calendar.HOUR_OF_DAY]
        val minute = calendar[Calendar.MINUTE]
        val timePickerDialog = TimePickerDialog(this,
            { view, selectedHour, selectedMinute -> showToast("Selected Time: $selectedHour:$selectedMinute") },
            hour,
            minute,
            true
        )
        timePickerDialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

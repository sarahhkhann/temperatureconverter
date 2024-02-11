package com.example.sarahkhan_temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBarCelsius: SeekBar = findViewById(R.id.celsiusseekbar)
        val seekBarFahrenheit: SeekBar = findViewById(R.id.fahrenheitseekbar)
        val celsiustemp: EditText = findViewById(R.id.celsiustemp)
        val fahrenheittemp: EditText = findViewById(R.id.fahrenheittemp)
        val message: EditText = findViewById(R.id.interestingmessage)

        //Set the initial positions of the bars
        seekBarCelsius.progress = 0
        seekBarFahrenheit.progress = 32


        seekBarCelsius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    val fahrenheit = (progress * 9 / 5) + 32
                    seekBarFahrenheit.progress = fahrenheit
                    celsiustemp.setText(progress.toString() + ".00°")
                    fahrenheittemp.setText(fahrenheit.toString() + ".00°")

                    if (progress <= 20) {
                        message.setText(R.string.warmer_message)
                    } else {
                        message.setText(R.string.colder_message)
                    }
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekBarFahrenheit.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {

                    val celsius = (progress - 32) * 5 / 9
                    seekBarCelsius.progress = celsius
                    fahrenheittemp.setText(progress.toString() + ".00°")
                    celsiustemp.setText(celsius.toString() + ".00°")

                    if (celsius <= 20) {
                        message.setText(R.string.warmer_message)
                    } else {
                        message.setText(R.string.colder_message)
                    }

                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })



    }
    private fun celsiusToFahrenheit(celsius: Double): Double = (celsius * 9 / 5) + 32
    private fun fahrenheitToCelsius(fahrenheit: Double): Double = (fahrenheit - 32) * 5 / 9
}
package com.mdshahsamir.chronometer

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var chronometer: Chronometer
    lateinit var button: Button
    private var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chronometer = findViewById(R.id.chronometer)
        button = findViewById(R.id.button)

        chronometer.base = SystemClock.elapsedRealtime() + 10000
        chronometer.isCountDown = true

        button.setOnClickListener {
            if (isRunning) {
                chronometer.stop()
                isRunning = false
                button.text = getString(R.string.start)
            } else {
                chronometer.start()
                button.text = getString(R.string.stop)
                isRunning = true
                button.text = getString(R.string.stop)
            }
        }
    }
}
package com.example.hrybkov_l13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hrybkov_l13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupListeners()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.button.setOnClickListener {
            val n = Integer.parseInt(binding.textView.text.toString())

            binding.textView.visibility = View.GONE
            binding.button.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE

            Thread(Runnable {
                Thread.sleep(((n + 1) / 10F * 1000).toLong())
                runOnUiThread {
                    updateElementsVisibility(n)
                }
            }).start()
        }
    }

    private fun updateElementsVisibility(n: Int) {
        binding.textView.visibility = View.VISIBLE
        binding.button.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
        binding.textView.text = (n + 1).toString()
    }
}
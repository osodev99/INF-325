package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener(this)
        binding.btnMinus.setOnClickListener(this)
        binding.btnMult.setOnClickListener(this)
        binding.btnDivi.setOnClickListener(this)
        binding.btnClear.setOnClickListener {
            binding.etNumA.text?.clear()
            binding.etNumB.text?.clear()
            binding.tvResult.text = "0"
        }

    }

    private fun isValid(): Boolean {
        val numA = binding.etNumA.text.toString()
        val numB = binding.etNumB.text.toString()

        return numA.isNotEmpty() && numB.isNotEmpty()
    }

    override fun onClick(p0: View?) {
        if (isValid() && p0 != null) {
            val numA = binding.etNumA.text.toString().toDouble()
            val numB = binding.etNumB.text.toString().toDouble()

            when (p0.id) {
                binding.btnAdd.id -> {
                    binding.tvResult.text = "${numA.plus(numB)}"
                }

                binding.btnMinus.id -> {
                    binding.tvResult.text = "${numA - numB}"
                }

                binding.btnMult.id -> {
                    binding.tvResult.text = "${numA * numB}"
                }

                binding.btnDivi.id -> {
                    if (numB == 0.0) {
                        binding.tvResult.text = "No es posible la division entre 0"
                    } else {
                        binding.tvResult.text = "${numA / numB}"
                    }
                }
            }

        } else {
            Toast.makeText(this, "Los datos no son validos", Toast.LENGTH_SHORT).show()
        }
    }
}
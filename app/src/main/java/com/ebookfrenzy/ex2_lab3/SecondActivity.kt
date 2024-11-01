package com.ebookfrenzy.ex2_lab3

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ebookfrenzy.ex2_lab3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private var _binding: ActivitySecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener{view: View ->onButtonClick(view)}

        val extras = intent.extras?:return
        val paramText = extras.getString("firstActivityString")
        binding.editText2.setText(paramText)
    }

    private fun onButtonClick(view: View) {
        finish()
    }

    override fun finish() {
        val data: Intent = Intent()
        val returnText = binding.editText2.text.toString()
        data.putExtra("returnText", returnText)
        setResult(RESULT_OK,data)
        super.finish()
    }
}
package com.ebookfrenzy.ex2_lab3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ebookfrenzy.ex2_lab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding:ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result:ActivityResult->
        if(result.resultCode== Activity.RESULT_OK){
            val data = result.data
            data?.let {
                if(it.hasExtra("returnText")){
                    val returnText = it.extras?.getString("returnText")
                    binding.textView1.setText(returnText)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener{view: View ->onButtonClick(view)}
    }

    private fun onButtonClick(view: View) {
        val intent = Intent(this,SecondActivity::class.java)
        val text = binding.textView1.text.toString()
        intent.putExtra("firstActivityString",text)
        startForResult.launch(intent)
    }
}
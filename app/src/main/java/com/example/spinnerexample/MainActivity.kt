package com.example.spinnerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.spinnerexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val balls = listOf("Basketball", "Football", "Baseball") //data source

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //comfigure the spinner
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, balls)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerId.adapter = adapter
        binding.spinnerId.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id:Long){
                val selected = parent?.getItemAtPosition(position).toString()
                binding.resultTest.text = "Your selection is " + selected
            }

            override fun onNothingSelected(parent: AdapterView<*>?){}
        }

    }

}
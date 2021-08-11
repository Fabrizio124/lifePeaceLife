package com.platzi.lifepeace.model

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.DatePicker
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.platzi.lifepeace.R
import com.platzi.lifepeace.databinding.ActivityMainBinding
import com.platzi.lifepeace.databinding.FragmentAnsiedadBinding
import java.text.DateFormat
import java.util.*




class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ansiedad.setOnClickListener(){
            val intent:Intent = Intent(this, FragmentAnsiedadBinding::class.java )
            startActivity(intent)
        }


        binding.meditacion.setOnClickListener {
            val newFragment = DatePickerFragment()
            newFragment.show(supportFragmentManager, "datePickker")
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val c: Calendar = Calendar.getInstance()
        c.set(year, month, dayOfMonth)
        val seletedDate :String = DateFormat.getInstance().format(c.time)

    }
}
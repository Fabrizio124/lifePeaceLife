package com.platzi.lifepeace

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import androidx.core.view.marginBottom
import com.platzi.lifepeace.databinding.ActivityNuevaMeditacionBinding
import com.platzi.lifepeace.model.DatePickerFragment
import java.text.DateFormat
import java.util.*

 class NuevaMeditacion : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private lateinit var binding: ActivityNuevaMeditacionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_nuevo_estres)
        binding  = ActivityNuevaMeditacionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnPickDate.setOnClickListener {
            var newFragment = DatePickerFragment()
            newFragment.show(supportFragmentManager, "datePickker")
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val c: Calendar = Calendar.getInstance()
        c.set(year, month, dayOfMonth)
        val seletedDate :String = DateFormat.getInstance().format(c.time)
    }
}
package com.platzi.lifepeace.model

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.text.TextUtils.replace
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.platzi.lifepeace.NuevaMeditacion
import com.platzi.lifepeace.NuevoEstres
import com.platzi.lifepeace.R
import com.platzi.lifepeace.databinding.ActivityMainBinding
import com.platzi.lifepeace.databinding.ActivityNuevaAnsiedadBinding
import com.platzi.lifepeace.databinding.FragmentAnsiedadBinding
import com.platzi.lifepeace.nuevaAnsiedad
import java.text.DateFormat
import java.util.*




class MainActivity : AppCompatActivity(),  DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    setContentView(R.layout.activity_main)
         binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       // val estres = binding<EditText>(binding.estrs)

        // Declaramos un val igualandolo a nuestro 'DatePickerFragment'
        // y lo llamamos en nuestra funcion makeCurrentFragment
        var datePickerFragment = DatePickerFragment()
        makeCurrentFragment(datePickerFragment)
        var activitymain = MainActivity()
        nuevoMakeCurrentFragment(activitymain)

       // Utilizamos 'setOnItemSelectedListener' para usar nuestro botom 'navCalendarFragment'
        binding.bnvMenu.setOnItemSelectedListener  {
            var newFragment = DatePickerFragment()
            when(it.itemId){
                //Cuando utilizamos el icono 'navCalendarFragment'
                    // llamamamos a 'DatePickerFragment' por medio de nuestro var
                R.id.navCalendarFragment -> newFragment.show(supportFragmentManager, "datePickker")
                R.id.navHomeFragment -> nuevoMakeCurrentFragment(activitymain)
            }
            true
        }

        //Botom de ansiedad para pasar a la vista de ansiedad
        binding.ansiedad.setOnClickListener(){
            val intent:Intent = Intent(this, nuevaAnsiedad::class.java )
            startActivity(intent)
            val message = "En esta sección te compartimos tres casos reales de situaciónes de ansiedad"
            Toast.makeText(this,message, Toast.LENGTH_LONG).show()
        }

        //Botom de estrs para pasar a la vista de estres
        binding.estrs.setOnClickListener {
            val intent:Intent = Intent(this, NuevoEstres::class.java )
            startActivity(intent)
            val nuevoMessage = "En esta sección te compartimos tres casos reales de situaciónes de estrés"
            Toast.makeText(this,nuevoMessage, Toast.LENGTH_LONG).show()
        }

        //Botom de meditacion para pasar a la vista de meditacion
        binding.meditacion.setOnClickListener(){
            val intent:Intent = Intent(this, NuevaMeditacion::class.java )
            startActivity(intent)
        }
    }


    private fun nuevoMakeCurrentFragment(activitymain: MainActivity) {
        supportFragmentManager.beginTransaction().apply {
            (R.id.fragment_container)
            commit()
        }
    }

        private fun makeCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fragment)
                commit()
            }

        //Utilizamos nuestro funcion 'onDateSet' para poner los datos de nuestro de 'DatePickerFragment'
        override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
            val c: Calendar = Calendar.getInstance()
            c.set(year, month, dayOfMonth)
            val seletedDate: String = DateFormat.getInstance().format(c.time)
        }

}
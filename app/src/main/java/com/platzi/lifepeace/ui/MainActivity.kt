package com.platzi.lifepeace.ui

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.platzi.lifepeace.*
import com.platzi.lifepeace.databinding.ActivityMainBinding
import com.platzi.lifepeace.data.model.AppDatabase
import com.platzi.lifepeace.data.model.DatePickerFragment
import com.platzi.lifepeace.data.model.FavoritesFragment
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity(),  DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var  database: AppDatabase

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
        var favoritesFragment = FavoritesFragment()
        favoritesMakeCurrentFragment(favoritesFragment)

       // Utilizamos 'setOnItemSelectedListener' para usar nuestro botom 'navCalendarFragment'
        binding.bnvMenu.setOnItemSelectedListener  {
            var newFragment = DatePickerFragment()
            when(it.itemId){
                //Cuando utilizamos el icono 'navCalendarFragment'
                    // llamamamos a 'DatePickerFragment' por medio de nuestro var
                R.id.navCalendarFragment -> newFragment.show(supportFragmentManager, "datePickker")
                R.id.navHomeFragment -> nuevoMakeCurrentFragment(activitymain)
                R.id.navFavoriteFragment -> favoritesMakeCurrentFragment(favoritesFragment)
                // R.id.navFavoriteFragment ->favorites(favoritesFragment)
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

    private fun favoritesMakeCurrentFragment(favoritesFragment: FavoritesFragment) {
        supportFragmentManager.beginTransaction().apply {
            (R.id.fragment_container)
            commit()
        }
    }

    /*private  fun favorites(favoritesFragment: FavoritesFragment) {
        val text1 = ("Un dia en el trabajo me pidieron hacer muchas cosas a la vez, me costo decir que no puesto queria la aprobacion del todo el personal.\n" +
                "        No me dio el tiempo para hacerlo, era tal la rapidez con la que intentaba hacerlo que me empezo a arder el estomago y me dolio la cabeza.\n" +
                "        Solo pensando en que no cumpliria la tarea y mis jefes que me dirian.\n" +
                "        Solucion:\n" +
                "        Desde aquel momento fuerte y agudo que pase trato de ser lo mas transparente en las peticiones que me dan trato de dar todo mi esfuerzo, pero sin afectarme emocionalmente.\n" +
                "        Muchos pensamos que el trabajo es todo en cierta parte de nuestra vida pero despues cuando miramos de retroceso no vale degastar la salud ni demasiado tiempo en ello.")
        database.textDao().insertFavorite(text1)
    }*/


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
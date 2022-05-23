package com.platzi.lifepeace.data.model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.platzi.lifepeace.R
import com.platzi.lifepeace.databinding.ActivityNuevaAnsiedadBinding
import com.platzi.lifepeace.databinding.ActivityNuevoEstresBinding


class FavoritesFragment : Fragment() {
    private lateinit var binding: ActivityNuevaAnsiedadBinding
    private lateinit var bindings: ActivityNuevoEstresBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityNuevaAnsiedadBinding.inflate(layoutInflater)
        bindings = ActivityNuevoEstresBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFavAnsiedad1.setOnClickListener{

        }
    }

}


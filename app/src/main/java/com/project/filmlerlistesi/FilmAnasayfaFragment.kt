package com.project.filmlerlistesi

import FilmlerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.filmlerlistesi.databinding.FragmentFilmAnasayfaBinding


class FilmAnasayfaFragment : Fragment() {

    private lateinit var tasarim: FragmentFilmAnasayfaBinding
    private lateinit var filmlerListesi:ArrayList<Filmler>
    private lateinit var adapter:FilmlerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_film_anasayfa,container,false)

        tasarim.rvfilm.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val f1=Filmler(1,"Anadoluda","anadoluda",2013,13.99,"Dram","Nuri Bilge Ceylan")
        val f2=Filmler(2,"Django","django",2011,15.99,"Aksiyon","Quentin Tarantino")
        val f3=Filmler(3,"Inception","inception",2009,18.99,"Bilim Kurgu","Christopher Nolan")
        val f4=Filmler(4,"Interstellar","interstellar",2015,10.99,"Bilim Kurgu","Christopher Nolan")
        val f5 = Filmler(5,"The Hateful Eight","thehatefuleight",2016,16.99,"Dram","Quentin Tarantino")
        val f6 = Filmler(6,"The Pianist","thepianist",2011,5.99,"Dram","Roman Polanski")

        filmlerListesi= ArrayList()
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)

        adapter= FilmlerAdapter(requireContext(),filmlerListesi)

        tasarim.rvfilm.adapter=adapter

        return tasarim.root
    }

}
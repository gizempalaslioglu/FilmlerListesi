package com.project.filmlerlistesi

import java.io.Serializable

data class Filmler(var film_id:Int
                   ,var film_adi:String
                   , var film_resim_adi:String
                   ,var film_yil:Int
                   ,var film_fiyat:Double
                   ,var kategori:String
                   ,var yonetmen:String):Serializable {
}
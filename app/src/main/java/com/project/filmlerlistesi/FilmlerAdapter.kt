import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.project.filmlerlistesi.FilmAnasayfaFragmentDirections
import com.project.filmlerlistesi.Filmler
import com.project.filmlerlistesi.databinding.FilmCardBinding
//filmListesi'nde Filmler sınıfından nesneler olacak
class FilmlerAdapter(var mContext:Context,var filmlerListesi:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(filmCardBinding: FilmCardBinding) :
        RecyclerView.ViewHolder(filmCardBinding.root) {
        var tasarim: FilmCardBinding

        init {
            this.tasarim = filmCardBinding
        }
    }

    //data binding işlemi
    //inflater metodları görsel tasarımı kodlamaya aktarmak için kullanılır
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = FilmCardBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position)
        //bu kodlamayla biz filmin adını sırayla arayüzde göstermiş olacağız ve teker teker görmüş olacağız

        holder.tasarim.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(film.film_resim_adi, "drawable", mContext.packageName)
        )
        holder.tasarim.textViewFilmAdi.text = film.film_adi
        holder.tasarim.textViewFiyat.text = "${film.film_fiyat} \u20BA"

        holder.tasarim.buttonSepet.setOnClickListener {
            Snackbar.make(it, "${film.film_adi} sepete eklendi.", Snackbar.LENGTH_SHORT).show()

        }
        holder.tasarim.filmCardview.setOnClickListener{   // card'a tıkladığımda detaysayfaya veri gönderme
            val gecis= FilmAnasayfaFragmentDirections.filmDetayGecis(film)
            //hem geçiş hem veri transferi
            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {  //adapter kaç veri işleyecek?
        return filmlerListesi.size
    }

}
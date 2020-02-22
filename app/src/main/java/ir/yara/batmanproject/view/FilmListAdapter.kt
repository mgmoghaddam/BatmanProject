package ir.yara.batmanproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.yara.batmanproject.R
import ir.yara.batmanproject.databinding.CardFilmBinding
import ir.yara.batmanproject.model.Search

class FilmListAdapter(filmList: List<Search>) : RecyclerView.Adapter<FilmListAdapter.VH>() {

    var filmList: List<Search> = filmList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding: CardFilmBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.card_film, parent, false
        )
        return VH(binding.root)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(h: VH, position: Int) {
        val film: Search = filmList[position]

        Glide.with(h.itemView.context)
            .load(film.poster)
            .into(h.binding.posterIV)

        h.binding.titleTxt.text = film.title

        h.binding.descriptionTxt.text = film.type + "\n" + film.year
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: CardFilmBinding = DataBindingUtil.bind(itemView)!!
    }
}

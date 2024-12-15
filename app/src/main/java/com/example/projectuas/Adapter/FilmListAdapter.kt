package com.example.projectuas.Adapter

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.projectuas.Activity.FilmDetailActivity
import com.example.projectuas.Models.Film
import com.example.projectuas.databinding.ViewholderFilmBinding

class FilmListAdapter(private val items:ArrayList<Film>):RecyclerView.Adapter<FilmListAdapter.Viewholder>() {
    private var context: Context? = null

    inner class Viewholder(private val binding: ViewholderFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(film: Film) {
            binding.nameTxt.text = film.Title
            val requestOptions = RequestOptions()
                .transform(CenterCrop(), RoundedCorners(30))

            Glide.with(context!!)
                .load(film.Poster)
                .apply(requestOptions)
                .into(binding.pic)

            binding.root.setOnClickListener {
                       val intent= Intent(context,FilmDetailActivity::class.java)
                        intent.putExtra("object",film)
                        context!!.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val binding = ViewholderFilmBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: FilmListAdapter.Viewholder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}
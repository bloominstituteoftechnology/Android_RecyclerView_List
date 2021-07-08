package sats.stackemhigh.android_sprint1_challenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_item_layout.view.*
import sats.stackemhigh.android_sprint1_challenge.R
import sats.stackemhigh.android_sprint1_challenge.model.Movie

class MovieListAdapter(val data: MutableList<Movie>) :
    RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // val image: ImageView = view.movie_image
        val title: TextView = view.movie_title
        val watched: TextView = view.movie_watched
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // holder.image.setImageDrawable(data[position].image)
        holder.title.text = data[position].title
        holder.watched.text = if (data[position].watched) {
            "Watched"
        } else {
            "NOT Watched"
        }
    }
}
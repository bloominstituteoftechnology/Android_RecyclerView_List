package sats.stackemhigh.android_sprint1_challenge.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_movie_list.*
import sats.stackemhigh.android_sprint1_challenge.R
import sats.stackemhigh.android_sprint1_challenge.model.Movie

class MovieListActivity : AppCompatActivity() {

    private val movieList = mutableListOf<Movie>()
    private var editMovieCheck: Boolean = false
    private var addMovieCheck: Boolean = false
    private var deleteMovieCheck: Boolean = false
    private var workingIndexValue: Int = -1

    companion object {
        const val EDIT_MOVIE_REQUEST_CODE = 9143
        const val DELETE_MOVIE_REQUEST_CODE = 7719
        const val MOVIE_DETAILS_REQUEST_KEY_DELETE = "ALKDJSHP9IN1OI8JAXLKVH"
        const val MOVIE_DETAILS_REQUEST_KEY_MODIFY = "P98I1BH3IREUHF09UPOKAUHIKUH"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        btn_add_movie.setOnClickListener {
            val addMovieIntent = Intent(this, MovieDetailsActivity::class.java)
            println(addMovieIntent)
            startActivityForResult(addMovieIntent, EDIT_MOVIE_REQUEST_CODE)
        }
    }

    override fun onResume() {
        super.onResume()

        when {
            addMovieCheck -> addToListView(workingIndexValue)
            editMovieCheck -> editListView(workingIndexValue)
            deleteMovieCheck -> refreshListView()
        }
    }

    private fun createTextView(movie: Movie, index: Int): TextView {

        // Set the index of the movie class = to movieList index
        movie.index = index
        val newMovieView = TextView(this)
        newMovieView.text = movie.title
        newMovieView.textSize = 26f
        newMovieView.id = movie.index

        newMovieView.setOnClickListener {
            val intent = Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra(MOVIE_DETAILS_REQUEST_KEY_MODIFY, movieList[index])
            println(intent)
            startActivityForResult(intent, EDIT_MOVIE_REQUEST_CODE)
        }

        return newMovieView
    }

    private fun verifyWatched(movie: Movie) {
        val view = findViewById<TextView>(movie.index)

        if (movie.watched) {
            view.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)
        } else {
            view.setPaintFlags(0)
        }
    }

    private fun addToListView(index: Int) {
        addMovieCheck = false
        val view = createTextView(movieList[index], index)
        sv_ll.addView(view)
        verifyWatched(movieList[index])
    }

    private fun editListView(index: Int) {
        editMovieCheck = false
        val newMovieInfo = movieList[index]
        val existingView = findViewById<TextView>(index)
        existingView.text = newMovieInfo.title
        verifyWatched(newMovieInfo)
    }

    private fun refreshListView() {
        deleteMovieCheck = false
        sv_ll.removeAllViews()
        for (i in 0 until movieList.size) {
            sv_ll.addView(createTextView(movieList[i], i))
            verifyWatched(movieList[i])
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        // hitting save button returns MOVIE_DETAILS_REQUEST_KEY_MODIFY back
        if (requestCode == EDIT_MOVIE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val newMovie = data?.getSerializableExtra(MOVIE_DETAILS_REQUEST_KEY_MODIFY) as Movie

            // If that movie is a new Movie, add it to movieList, update the index of that
            // new Movie, and set addMovieCheck to true
            if (newMovie.index < 0) {
                movieList.add(newMovie)
                newMovie.index = movieList.size - 1
                workingIndexValue = newMovie.index
                addMovieCheck = true

                // Otherwise, modify movieList and set editMovieCheck to true
            } else {
                movieList[newMovie.index] = newMovie
                workingIndexValue = newMovie.index
                editMovieCheck = true
            }

            // Hitting delete button returns DELETE_MOVIE_REQUEST_CODE back
        } else if (requestCode == EDIT_MOVIE_REQUEST_CODE && resultCode == DELETE_MOVIE_REQUEST_CODE) {
            val newMovie = data?.getSerializableExtra(MOVIE_DETAILS_REQUEST_KEY_DELETE) as Movie

            // Remove that Movie from the list and set deleteMovieCheck to true to refresh listView
            movieList.removeAt(newMovie.index)
            deleteMovieCheck = true

            // Refactor Movie.index values for each Movie in the list
            for (i in 0 until movieList.size) {
                movieList[i].index = i
            }
        }
    }
}
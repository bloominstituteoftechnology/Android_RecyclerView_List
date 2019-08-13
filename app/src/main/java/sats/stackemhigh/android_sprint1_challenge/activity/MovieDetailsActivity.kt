package sats.stackemhigh.android_sprint1_challenge.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie_details.*
import sats.stackemhigh.android_sprint1_challenge.R
import sats.stackemhigh.android_sprint1_challenge.activity.MovieListActivity.Companion.DELETE_MOVIE_REQUEST_CODE
import sats.stackemhigh.android_sprint1_challenge.activity.MovieListActivity.Companion.MOVIE_DETAILS_REQUEST_KEY_DELETE
import sats.stackemhigh.android_sprint1_challenge.activity.MovieListActivity.Companion.MOVIE_DETAILS_REQUEST_KEY_MODIFY
import sats.stackemhigh.android_sprint1_challenge.model.Movie

class MovieDetailsActivity : AppCompatActivity() {

    private var index: Int = -1
    private var watched: Boolean = false
    private var myMovie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        // Delete Button Details
        btn_delete.setOnClickListener {
            if (index >= 0) {
                val intentDelete = Intent()
                intentDelete.putExtra(MOVIE_DETAILS_REQUEST_KEY_DELETE, Movie(myMovie?.title ?: "Junk", index, watched))
                setResult(DELETE_MOVIE_REQUEST_CODE, intentDelete)
                println(intentDelete)
                finish()
            } else {
                Toast.makeText(this, "No item to delete", Toast.LENGTH_SHORT).show()
            }

        }

        // Save button Details
        btn_save.setOnClickListener {
            if (et_movie_name.text.isNotEmpty()) {
                val intentSave = Intent()
                intentSave.putExtra(MOVIE_DETAILS_REQUEST_KEY_MODIFY, createMovie(watched))
                setResult(Activity.RESULT_OK, intentSave)
                finish()
            } else {
                Toast.makeText(this, "Please enter a Movie Name", Toast.LENGTH_SHORT).show()
            }
        }

        switch_boolean.setOnClickListener() {
            watched = switch_boolean.isChecked
        }

        // If there was data passed, pull it in to a value
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            myMovie = bundle.getSerializable(MOVIE_DETAILS_REQUEST_KEY_MODIFY) as Movie
            loadMovieDetails(myMovie)
        }
    }

    private fun loadMovieDetails(movie: Movie?) {
        et_movie_name.setText(movie?.title)
        switch_boolean.isChecked = movie?.watched ?: false
        watched = switch_boolean.isChecked
        index = movie!!.index
    }

    private fun createMovie(watched: Boolean): Movie {
        return Movie(et_movie_name.text.toString(), index, watched)
    }
}
package ir.yara.batmanproject.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

@SuppressLint("Registered")
class BatmanMovies : Application() {


    init {
        instance = this
    }

    companion object {
        private var instance: BatmanMovies? = null

        fun applicationContext() : BatmanMovies {
            return instance as BatmanMovies
        }
    }

    override fun onCreate() {
        super.onCreate()

}
}
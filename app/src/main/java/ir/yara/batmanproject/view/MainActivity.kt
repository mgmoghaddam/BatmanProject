package ir.yara.batmanproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ir.yara.batmanproject.R
import ir.yara.batmanproject.databinding.ActivityMainBinding
import ir.yara.batmanproject.model.Search
import ir.yara.batmanproject.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        configPage()
    }

    private fun configPage() {
        viewModel.getFilms()
        observes()
    }

    private fun observes() {
        viewModel.filmList.observe(this, Observer {list ->
            if (list.isNotEmpty()) {
                configRV(list)
            } else {
                viewModel.getData()
                configPage()
            }
        })
    }

    private fun configRV(list: List<Search>) {
        binding.moviesRV.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.moviesRV.adapter = FilmListAdapter(list)
    }
}

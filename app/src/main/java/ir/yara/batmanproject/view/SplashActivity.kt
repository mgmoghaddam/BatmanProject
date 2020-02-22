package ir.yara.batmanproject.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.yara.batmanproject.R
import ir.yara.batmanproject.databinding.ActivitySplashBinding
import ir.yara.batmanproject.viewModel.MainViewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.checkData()
        configPage()
    }

    private fun configPage() {
        animatePic()
        binding.progress.visibility = View.VISIBLE
        observes()
    }

    private fun animatePic() {
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.fadein)
        binding.logoIV.startAnimation(animation)
    }

    private fun observes() {
        viewModel.hasDataLD.observe(this, Observer { hasData ->
            if (hasData) {
                val intent = Intent(this, MainActivity::class.java)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    overridePendingTransition(R.anim.fragment_fade_enter, R.anim.fragment_fade_exit)
                }
                startActivity(intent)
                finish()
            } else {
                viewModel.checkInternet()
            }
        })
        viewModel.isInternetConnectedLD.observe(this, Observer { connected ->
            if (connected) {
                viewModel.getData()
            } else {
                val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
                dialog.setMessage(R.string.dialogInternetWarning)
                    .setNegativeButton("Cancel") { dialogInterface, i ->
                        finish()
                    }
                    .setPositiveButton("Try Again") { dialogInterface, i ->
                        viewModel.checkInternet()
                    }
            }
        })

    }

}
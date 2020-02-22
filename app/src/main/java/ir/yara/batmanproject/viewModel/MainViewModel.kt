package ir.yara.batmanproject.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.yara.batmanproject.model.Search
import ir.yara.batmanproject.repository.MainRepository
import ir.yara.batmanproject.utils.BatmanMovies
import ir.yara.batmanproject.utils.CheckInternetKotlin

class MainViewModel : ViewModel() {
    private val repository: MainRepository = MainRepository().getInstance()
    var isInternetConnectedLD: MutableLiveData<Boolean> = MutableLiveData()
    var hasDataLD: MutableLiveData<Boolean> = MutableLiveData()
    var filmList: MutableLiveData<List<Search>> = MutableLiveData()

    fun checkInternet() {
        isInternetConnectedLD.value =
            CheckInternetKotlin.isNetworkWorking(BatmanMovies.applicationContext())
    }

    init {
        repository.attachVM(this)
    }

    fun checkData() {
        repository.checkData()
    }

    fun hasData(b: Boolean) {
        hasDataLD.value = b
    }

    fun getData() {
        repository.getData()
    }

    fun firstDataSet(b: Boolean) {
        hasDataLD.value = b
    }

    fun getFilms() {
        repository.getFilms()
    }

    fun setFilms(search: List<Search>) {
        filmList.value = search
    }


}
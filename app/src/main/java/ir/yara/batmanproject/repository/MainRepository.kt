package ir.yara.batmanproject.repository

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers
import ir.yara.batmanproject.model.FirstApi
import ir.yara.batmanproject.model.Search
import ir.yara.batmanproject.request.MainRequests
import ir.yara.batmanproject.utils.BatmanMovies
import ir.yara.batmanproject.utils.db.AppDataBase
import ir.yara.batmanproject.viewModel.MainViewModel

class MainRepository {

    private var instance: MainRepository? = null
    fun getInstance(): MainRepository {
        if (instance == null) {
            instance = MainRepository()
        }
        return instance as MainRepository
    }


    private lateinit var viewModel: MainViewModel
    private val requests: MainRequests = MainRequests().getInstance()

    val db = AppDataBase(BatmanMovies.applicationContext())

    fun attachVM(mainViewModel: MainViewModel) {
        viewModel = mainViewModel
    }

    fun checkData() {

        db.moviesList()!!
            .getAllList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isNotEmpty()) {
                    viewModel.hasData(true)
                } else {
                    viewModel.hasData(false)
                }
            },
                {error->
                    Log.e("error", error.message!!)
                    viewModel.hasData(false)
                })

//        db.moviesList()!!.getAllList()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : Observer<List<Search>> {
//                override fun onComplete() {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun onSubscribe(d: Disposable) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun onNext(t: List<Search>) {
//                    if (t.isNotEmpty()) {
//                        viewModel.hasData(true)
//                    } else {
//                        viewModel.hasData(false)
//                    }
//                }
//
//                override fun onError(e: Throwable) {
//                    Log.e("getDataErr", e.message!!)
//                    viewModel.hasData(false)
//                }
//            })
    }

    fun getData() {
        requests.getData()
    }

    fun setData(t: List<Search>) {

        db.moviesList()!!
            .insertList(t)!!
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewModel.firstDataSet(true)
            },
                {
                    viewModel.firstDataSet(false)
                })

//        db.moviesList()!!.insertList(t)!!
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : DisposableCompletableObserver() {
//                override fun onComplete() {
//                    viewModel.firstDataSet(true)
//                }
//
//                override fun onError(e: Throwable) {
//                    viewModel.firstDataSet(false)
//                }
//
//            })
    }

    fun getFilms() {
        db.moviesList()!!
            .getAllList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewModel.setFilms(it)
            },{

            })


//        db.moviesList()!!
//            .getAllList()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : Observer<List<Search>> {
//                override fun onComplete() {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun onSubscribe(d: Disposable) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun onNext(t: List<Search>) {
//                    viewModel.setFilms(t)
//                }
//
//                override fun onError(e: Throwable) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//            })
    }

    init {
        requests.attachRepo(this)
    }


}
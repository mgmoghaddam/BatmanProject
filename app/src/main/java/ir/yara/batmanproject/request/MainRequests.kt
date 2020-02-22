package ir.yara.batmanproject.request

import android.util.Log
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.yara.batmanproject.model.FirstApi
import ir.yara.batmanproject.repository.MainRepository
import ir.yara.batmanproject.utils.ApiCalls
import ir.yara.batmanproject.utils.RetrofitClientInstance

class MainRequests {

    private var instance: MainRequests? = null
    private lateinit var repository: MainRepository
    private val apiCalls: ApiCalls = RetrofitClientInstance.getApiService()!!

    fun getInstance(): MainRequests {
        if (instance == null) {
            instance = MainRequests()
        }
        return instance as MainRequests
    }

    fun attachRepo(mainRepository: MainRepository) {
        repository = mainRepository
    }

    fun getData() {

        apiCalls.firstApi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                repository.setData(it.search)
            },
                {
                    Log.e("error",it.message)
                })

//        apiCalls.firstApi()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : Observer<FirstApi> {
//                override fun onComplete() {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun onSubscribe(d: Disposable) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun onNext(t: FirstApi) {
//                    repository.setData(t.search)
//                }
//
//                override fun onError(e: Throwable) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//            })
    }


}
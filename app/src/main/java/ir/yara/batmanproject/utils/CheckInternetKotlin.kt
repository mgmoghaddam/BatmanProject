package ir.yara.batmanproject.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.Dispatcher
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket
import java.net.SocketAddress

class CheckInternetKotlin {
    companion object{
        fun isNetworkWorking(context: Context): Boolean {
            return isInternetConnected(context)
        }

        private fun isInternetConnected(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).state == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).state == NetworkInfo.State.CONNECTED
            ) {
                hasData()
            } else false
        }

        private fun hasData(): Boolean = runBlocking {
            var connected = false
            val job = GlobalScope.launch(Dispatchers.IO) {
                val timeoutMs = 1500
                val sock = Socket()
                val socketAddress: SocketAddress =
                    InetSocketAddress("8.8.8.8", 53)
                try {
                    sock.connect(socketAddress, timeoutMs)
                    connected = true
                } catch (e: IOException) {
                    e.printStackTrace()
                    connected = false
                }
                try {
                    sock.close()
                    connected = true
                } catch (e: IOException) {
                    e.printStackTrace()
                    connected = false
                }
            }
            job.join()
            return@runBlocking connected
        }
    }

}

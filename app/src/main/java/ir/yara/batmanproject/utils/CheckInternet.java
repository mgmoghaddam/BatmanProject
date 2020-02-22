//package ir.yara.batmanproject.utils;
//
//import android.content.Context;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//import java.net.SocketAddress;
//
//
///**
// * Created by Mostafa on 7/10/2019.
// */
//
//public class CheckInternet {
//
//    public static boolean isNetworkWorking(Context context) {
//        return isInternetConnected(context);
//    }
//
//    private static boolean isInternetConnected(Context context) {
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
//                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
//            return hasData();
//        } else
//            return false;
//    }
//
//    private static boolean hasData() {
//        final boolean[] connected = {false};
//
//        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                int timeoutMs = 1500;
//                Socket sock = new Socket();
//                SocketAddress socketAddress = new InetSocketAddress("8.8.8.8", 53);
//
//                try {
//                    sock.connect(socketAddress, timeoutMs);
//                    connected[0] = true;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                     connected[0] = false;
//                }
//                try {
//                    sock.close();
//                    connected[0] = true;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    connected[0] = false;
//                }
//
//            }
//        });
//        return connected[0];
//    }
//
//}

package util

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class ConnectionManager {

    fun  checkConnectivity(context: Context) : Boolean{

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE ) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork?. isConnected !=null){
            return activeNetwork.isConnected
        }else{
            return false
            //  True - if the network has internet
            //  False - if the network  does not  have internet
            //  Null - if the network is broken/inactive
        }

    }
}
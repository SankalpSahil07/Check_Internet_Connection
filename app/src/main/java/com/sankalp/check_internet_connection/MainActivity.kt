package com.sankalp.check_internet_connection

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import util.ConnectionManager

class MainActivity : AppCompatActivity() {

    lateinit var btn_checkInternet : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_checkInternet =  findViewById(R.id.button_internetConnection)

        btn_checkInternet.setOnClickListener {
            if (ConnectionManager().checkConnectivity(this as Context)){
                // Internet is available
                val dialog = AlertDialog.Builder(this as Context)
                dialog.setTitle("Success")
                dialog.setMessage("Internet Connection Found")
                dialog.setPositiveButton("Ok"){text,listener ->
                    // Does Nothing
                }
                dialog.setNegativeButton("Cancel"){text,listener->
                    // Does Nothing
                }
                dialog.create()
                dialog.show()
            }else {
                // Internet is not available
                val dialog = AlertDialog.Builder(this as Context)
                dialog.setTitle("Error")
                dialog.setMessage("Internet Connection not Found")
                dialog.setPositiveButton("Open Settings") {text,listener->
                    val settingsIntent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                    startActivity(settingsIntent)
                    this?.finish()
                }
                dialog.setNegativeButton("Exit"){text,listener->
                    ActivityCompat.finishAffinity(this as Activity)
                }
                dialog.create()
                dialog.show()
            }
        }


    }
}
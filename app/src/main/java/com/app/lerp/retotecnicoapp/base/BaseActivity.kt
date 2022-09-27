package com.app.lerp.retotecnicoapp.base

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.app.lerp.retotecnicoapp.ui.dialog.ProgressDialog
import com.google.android.material.snackbar.Snackbar


abstract class BaseActivity : AppCompatActivity() {

    abstract fun startCreateViewBinding(savedInstanceState: Bundle?)
    abstract fun getDataActivityForResult(data: Intent?)
    abstract fun initView()
    abstract fun initViewModel()

    private var progressDialog: ProgressDialog = ProgressDialog()
    private var progressIniciado = false
    private var statusOnline = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startCreateViewBinding(savedInstanceState)
        initView()
        initViewModel()
    }

    fun hideKeyBoard(view: View) {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showProgressDialog() {
        if (!progressIniciado) {
            progressDialog.isCancelable = false
            progressIniciado = true
            progressDialog.show(supportFragmentManager, "")
        }
    }


    fun hideProgressDialog() {
        if (progressIniciado) {
            progressDialog.dismiss()
            progressIniciado = false
        }
    }

    fun showMessageSnack(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
            .show()
    }

    fun showMessageToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        capabilities?.let {
            if (it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                statusOnline = true
                return true
            } else if (it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                statusOnline = true
                return true
            } else if (it.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                statusOnline = true
                return true
            }
        }
        return false
    }

    fun <T> goToOtherActivity(cls: Class<T>, finishActual: Boolean = false) {
        val intent = Intent(baseContext, cls)
        if (finishActual) intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

    fun getAppVersion(context: Context): String {
        var appVersion = "Desconocido"
        try {
            val packageInfo =
                context.packageManager.getPackageInfo(context.packageName, 0)
            appVersion = packageInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return appVersion
    }

    @SuppressLint("ClickableViewAccessibility")
    fun EditText.onRightDrawableClicked(onClicked: (view: EditText) -> Unit) {
        this.setOnTouchListener { v, event ->
            var hasConsumed = false
            if (v is EditText) {
                if (event.x >= v.width - v.totalPaddingRight) {
                    if (event.action == MotionEvent.ACTION_UP) {
                        onClicked(this)
                    }
                    hasConsumed = true
                }
            }
            hasConsumed
        }
    }

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data
                getDataActivityForResult(data)
            }
        }

}
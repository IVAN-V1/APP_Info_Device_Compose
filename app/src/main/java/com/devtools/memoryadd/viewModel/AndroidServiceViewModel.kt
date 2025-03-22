package com.devtools.memoryadd.viewModel

import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AndroidServiceViewModel :ViewModel() {


    fun getVersionAndroid(callback: (String) -> Unit) {

        viewModelScope.launch {
            val version = withContext(Dispatchers.IO) {
                Build.VERSION.RELEASE
            }
            callback(version)
        }
    }

    fun getBrandDevice(callback: (String) -> Unit) {
        viewModelScope.launch {
            val brand = withContext(Dispatchers.IO) {
                Build.BRAND
            }
            callback(brand)
        }
    }


    fun getBOARD(callback: (String) -> Unit) {
        viewModelScope.launch {
            val board = withContext(Dispatchers.IO) {
                Build.BOARD
            }
            callback(board)
        }
    }


    fun getMANUFACTURER(callback: (String) -> Unit) {
        viewModelScope.launch {
            val manufacturer = withContext(Dispatchers.IO) {
                Build.MANUFACTURER
            }
            callback(manufacturer)
        }
    }



fun getMODEL(callback: (String) -> Unit) {
        viewModelScope.launch {
            val model = withContext(Dispatchers.IO) {
                Build.MODEL
            }
            callback(model)
        }
    }


    fun getHARDWARE(callback: (String) -> Unit) {
        viewModelScope.launch {
            val hardware = withContext(Dispatchers.IO) {
                Build.HARDWARE
            }
            callback(hardware)
        }
    }

    fun getHOST(callback: (String) -> Unit) {
        viewModelScope.launch {
            val host = withContext(Dispatchers.IO) {
                Build.HOST
            }
            callback(host)
        }
    }

    fun getTAGS(callback: (String) -> Unit) {
        viewModelScope.launch {
            val tags = withContext(Dispatchers.IO) {
                Build.TAGS
            }
            callback(tags)
        }
    }

    fun getTYPE(callback: (String) -> Unit) {
        viewModelScope.launch {
            val type = withContext(Dispatchers.IO) {
                Build.TYPE
            }
            callback(type)
        }
    }

    fun getUSER(callback: (String) -> Unit) {
        viewModelScope.launch {
            val user = withContext(Dispatchers.IO) {
                Build.USER
            }
            callback(user)
        }
    }



    fun getCODENAME(callback: (String) -> Unit) {
        viewModelScope.launch {
            val codename = withContext(Dispatchers.IO) {
                Build.VERSION.CODENAME
            }
            callback(codename)
        }
    }



    fun getINCREMENTAL(callback: (String) -> Unit) {
        viewModelScope.launch {
            val incremental = withContext(Dispatchers.IO) {
                Build.VERSION.INCREMENTAL
            }
            callback(incremental)
        }
    }


    fun getSDK(callback: (Int) -> Unit) {
        viewModelScope.launch {
            val sdk = withContext(Dispatchers.IO) {
                Build.VERSION.SDK_INT
            }
            callback(sdk)
        }
    }


    fun getRelease(callback: (String) -> Unit) {
        viewModelScope.launch {
            val release = withContext(Dispatchers.IO) {
                Build.VERSION.RELEASE
            }
            callback(release)
        }
    }



    fun getSecurityPatch(callback: (String) -> Unit) {
        viewModelScope.launch {
            val securityPatch = withContext(Dispatchers.IO) {
                Build.VERSION.SECURITY_PATCH
            }
            callback(securityPatch)
        }
    }


    fun getSerial(callback: (String) -> Unit) {
        viewModelScope.launch {
            val serial = withContext(Dispatchers.IO) {
                Build.SERIAL
            }
            callback(serial)
        }
    }


}
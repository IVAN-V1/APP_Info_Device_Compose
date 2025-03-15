package com.devtools.memoryadd.data.repository

class AndroidService {





   /**
    * Obtiene la versión del sistema operativo Android como una cadena de texto.
    *
    * Esta función devuelve la cadena de texto legible que representa la versión del
    * sistema operativo Android que se está ejecutando en el dispositivo. Se corresponde
    * con el valor de `android.os.Build.VERSION.RELEASE`. Por ejemplo, podría devolver
    * "13", "12", "11", "10" o similar.
    *
    * @return Una cadena de texto que representa la versión del sistema operativo Android
    *         (por ejemplo, "13", "12", "11").
    */


   fun getVersionAndroid(): String {
       return android.os.Build.VERSION.RELEASE
   }

    fun getBrandDevice(): String {
        return android.os.Build.BRAND
    }

    fun getBOARD(): String {
        return android.os.Build.BOARD
    }



}
package com.devtools.memoryadd.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CorutineTest : ViewModel() {


    var text by mutableStateOf("")


    /**
     * `llama_test` es una función que inicia una corrutina dentro del `viewModelScope`.
     *
     * Esta función está diseñada para ejecutar una tarea potencialmente larga o asíncrona
     * encapsulada dentro de la función `test()`. Al usar `viewModelScope.launch`, la corrutina
     * está vinculada al ciclo de vida del ViewModel. Esto asegura que la corrutina se cancele
     * automáticamente cuando el ViewModel se limpie, evitando posibles fugas de memoria o
     * comportamientos inesperados.
     *
     * **Funcionalidad:**
     * 1. Inicia una nueva corrutina usando `viewModelScope.launch`.
     * 2. Dentro de esta corrutina, llama a la función `test()`.
     * 3. La función `test()` se ejecutará de forma asíncrona.
     *
     * **Conocimiento del Ciclo de Vida:**
     * La corrutina creada aquí se cancelará automáticamente cuando el ViewModel asociado
     * con el `viewModelScope` se limpie.
     *
     *
     */


    fun  testCorrutinas () {

        viewModelScope.launch() {
            println("Corrutina iniciada")
            test()
        }


        viewModelScope.async {

            var resul=metodoAsych()

            println("Resultado de la corrutina $resul")

        }

    }

    /**
     *
     *
     * `Launch` se se usa para lanzar una corrutina sin que devuelva un valor,
     *
     *  `Async` se usa para lanzar una corrutina que devuelva un valor como una api
     *
     *
     *
     */

    private suspend fun test() {
        delay(5000)
        text = "Corrutina finalizada"
        println("Corrutina finalizada")
    }


    private suspend fun metodoAsych(): String {

        return "Hola"
        println("Corrutina finalizada")
    }


}
package com.example.loteria.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {

    private val _contador = mutableIntStateOf(0) // el _ se usa para identificar valores privados
    val contador: State<Int> = _contador

    fun add() {
        _contador.intValue ++
    }

    // var contador = mutableIntStateOf(0)
}
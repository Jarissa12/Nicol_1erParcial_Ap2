package com.ucne.proj_1erparcial_ap2.ui.Prestamo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.proj_1erparcial_ap2.data.Repository.PrestamosRepository
import com.ucne.proj_1erparcial_ap2.data.local.Entity.PrestamoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject





data class PrestamosUiState(
    val prestamosList : List<PrestamoEntity> = emptyList()
)


@HiltViewModel
class PrestamosViewModel @Inject constructor(
    private val prestamosRepository: PrestamosRepository
) : ViewModel() {


    var Deudor by  mutableStateOf("")
    var Concepto by  mutableStateOf("")
    var Monto by mutableStateOf("")

    var uiState = MutableStateFlow(PrestamosUiState())

        private set

    fun insertar() {

        val prestamo = PrestamoEntity(
            Deudor = Deudor,
            Concepto = Concepto,
            Monto = Monto.toDoubleOrNull() ?: 0.0
        )

        viewModelScope.launch(Dispatchers.IO) {
            prestamosRepository.insert(prestamo)
            Limpiar()
        }
    }


    init{

        getList()
    }

    fun getList(){

        viewModelScope.launch(Dispatchers.IO) {
            prestamosRepository.getList().collect { Lista ->
                uiState.update{

                    it.copy(prestamosList = Lista)
                }
            }
        }
    }

    private fun Limpiar() {
        var Deudor= ""
        var concepto= ""
        var Monto= ""
    }


}
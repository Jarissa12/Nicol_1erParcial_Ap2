package com.ucne.proj_1erparcial_ap2.data.local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity ("Prestamo")

data class PrestamoEntity(

    @PrimaryKey(autoGenerate = true)
    var PrestamoId: Int?=null,
    var Deudor: String,
    var Concepto: String,
    var Monto: Double

)

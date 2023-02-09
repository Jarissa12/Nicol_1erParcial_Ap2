package com.ucne.proj_1erparcial_ap2.data.Repository

import com.ucne.proj_1erparcial_ap2.data.local.Entity.PrestamoEntity
import com.ucne.proj_1erparcial_ap2.data.local.dao.PrestamoDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject



    class PrestamosRepository @Inject constructor(

        private val PrestamoDao: PrestamoDao

    ){

        suspend fun insert (prestamos :PrestamoEntity){

            return PrestamoDao.insert(prestamos)
        }




        fun getList(): Flow<List<PrestamoEntity>> = PrestamoDao.getList()

    }



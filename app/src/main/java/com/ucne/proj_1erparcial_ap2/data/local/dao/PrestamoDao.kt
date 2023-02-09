package com.ucne.proj_1erparcial_ap2.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ucne.proj_1erparcial_ap2.data.local.Entity.PrestamoEntity

interface PrestamoDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(PrestamoEntity: PrestamoEntity)


    @Query (
        """
            Select * from PrestamsoEntity 
            WHERE PrestamoId=:PrestamoId
             LIMIT 1
        """
    )


     fun getList()
}
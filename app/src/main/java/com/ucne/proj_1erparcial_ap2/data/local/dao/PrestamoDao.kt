package com.ucne.proj_1erparcial_ap2.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ucne.proj_1erparcial_ap2.data.local.Entity.PrestamoEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PrestamoDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(PrestamoEntity: PrestamoEntity)


    @Query (
        """
            Select * from Prestamo 
            WHERE PrestamoId=:PrestamoId
            
        """
    )
    suspend fun find (PrestamoId : Int ) :PrestamoEntity?

    @Query ("SELECT * FROM Prestamo")

    fun getList():Flow<List<PrestamoEntity>>

}
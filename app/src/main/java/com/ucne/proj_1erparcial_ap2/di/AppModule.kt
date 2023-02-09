package com.ucne.proj_1erparcial_ap2.di

import android.content.Context
import androidx.room.Room
import com.ucne.proj_1erparcial_ap2.data.local.PrestamoDd
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // TODO: Inyectar la base de datos
    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): PrestamoDd{
        return Room.databaseBuilder(
            context,
            PrestamoDd::class.java,
            "Prestamo.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    // TODO: Inyectar el DAO 
 @Singleton
    @Provides
    fun providesPrestamoDao(db: PrestamoDd) = db.prestamoDao
}
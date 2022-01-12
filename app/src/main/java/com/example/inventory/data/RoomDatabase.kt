package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Creamos la clase database que proporciona intancias de Dao
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemRoomDatabase: RoomDatabase() {

    //Funcion paraa mostrar el itemDao
    abstract fun itemDao(): ItemDao

    //objeto complementario para acceder a los metodos
    //crear u obtener la base de datos
    companion object {
        private var INSTANCE: ItemRoomDatabase? = null
        fun getDatabase(context: Context): ItemRoomDatabase{
            return INSTANCE ?: synchronized(this) {
                val intance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemRoomDatabase::class.java,
                    "item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = intance
                return intance

            }
        }
    }
}
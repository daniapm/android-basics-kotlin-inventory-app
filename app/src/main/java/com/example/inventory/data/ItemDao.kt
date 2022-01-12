package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import androidx.room.Query
import androidx.room.Dao



//Definimos la interfaz dao para acceder a la base de datos
@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>
}
package com.apdef.shopapps

import androidx.room.*

@Dao
interface GoodsDao {
    @Insert
    fun insert(goods: Goods)

    @Update
    fun update(goods: Goods)

    @Delete
    fun delete(goods: Goods)

    @Query("SELECT * FROM goods")
    fun getAll() : List<Goods>

    @Query("SELECT * FROM goods WHERE id = :id")
    fun getById(id: Int) : List<Goods>
}
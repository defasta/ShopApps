package com.apdef.shopapps

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Goods (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id") var id : Int = 0,
    @ColumnInfo(name= "name") var name : String = "",
    @ColumnInfo(name = "jumlah") var jumlah : String = "",
    @ColumnInfo(name = "suppliers") var suppliers : String = ""

):Parcelable
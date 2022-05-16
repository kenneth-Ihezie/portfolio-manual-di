package com.example.myportfolio.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "portfolio")
data class Portfolio(
    @ColumnInfo(name = "portfolio_item") val portfolioItem: String,
    @ColumnInfo(name = "portfolio_cost") val portfolioCost: String,
    @ColumnInfo(name = "portfolio_time") val portfolioTime: String,
    @ColumnInfo(name = "portfolio_date") val portfolioDate: String
)

{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "portfolio_id") var portfolioId: Long = 0

}

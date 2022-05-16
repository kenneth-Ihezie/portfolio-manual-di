package com.example.myportfolio.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PortfolioDao {
    @Query("SELECT * from portfolio ORDER BY portfolio_id DESC")
    fun getAllPortfolio(): LiveData<List<Portfolio>>

    @Insert
     fun insertPortfolio(portfolio: Portfolio)

    @Delete
    fun deletePortfolio(portfolio: Portfolio)

    @Query("UPDATE portfolio SET portfolio_item =:portfolioItem, portfolio_cost =:portfolioCost, portfolio_time =:portfolioTime, portfolio_date =:portfolioDate WHERE portfolio_id =:portfolioId")
    fun updatePortfolio(portfolioId: Long, portfolioItem: String, portfolioCost: String, portfolioTime: String, portfolioDate: String)

//    @Query("UPDATE portfolio SET portfolio_date=:portfolioDate WHERE portfolio_id=:portfolioId")
//    fun updateDate(portfolioDate: String, portfolioId: Long)
/*
    @Query("SELECT portfolio_id FROM portfolio WHERE portfolio_item =:portfolioItemId")
    fun getId(portfolioItemId: String)*/

    @Query("DELETE FROM portfolio")
    suspend fun deleteAll()

    @Update
    fun updatePortfolioSingle(portfolio: Portfolio)
}
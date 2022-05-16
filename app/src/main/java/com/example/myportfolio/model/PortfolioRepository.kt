package com.example.myportfolio.model

import androidx.lifecycle.LiveData

class PortfolioRepository(private val portfolioDao: PortfolioDao) {
    val allPortfolio: LiveData<List<Portfolio>> = portfolioDao.getAllPortfolio()

   fun insertPortfolio(portfolio: Portfolio){
         portfolioDao.insertPortfolio(portfolio)
    }

    fun deletePortfolio(portfolio: Portfolio){
        portfolioDao.deletePortfolio(portfolio)
    }

    suspend fun deleteAll(){
        portfolioDao.deleteAll()
    }
    fun updatePortfolio(portfolioid: Long, portfolioItem: String, portfolioCost: String, portfolioDate: String, portfolioTime: String){
        portfolioDao.updatePortfolio(portfolioid, portfolioItem, portfolioCost, portfolioTime, portfolioDate)
    }
     fun updatePortfolioSingle(portfolio: Portfolio){
        portfolioDao.updatePortfolioSingle(portfolio)
    }
}
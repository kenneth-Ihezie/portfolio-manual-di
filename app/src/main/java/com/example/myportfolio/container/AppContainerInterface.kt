package com.example.myportfolio.container

import androidx.lifecycle.LiveData
import com.example.myportfolio.model.Portfolio
import com.example.myportfolio.model.PortfolioDao

class AppContainerInterface() : PortfolioDao {
    override fun getAllPortfolio(): LiveData<List<Portfolio>> {
        val portfolioDao: PortfolioDao
       val allPortfolio: LiveData<List<Portfolio>> = portfolioDao.getAllPortfolio()
        return allPortfolio
    }

    override fun insertPortfolio(portfolio: Portfolio) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deletePortfolio(portfolio: Portfolio) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updatePortfolio(
        portfolioId: Long,
        portfolioItem: String,
        portfolioCost: String,
        portfolioTime: String,
        portfolioDate: String
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updatePortfolioSingle(portfolio: Portfolio) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
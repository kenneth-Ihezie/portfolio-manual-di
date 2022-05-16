package com.example.myportfolio.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myportfolio.model.MyDatabase
import com.example.myportfolio.model.Portfolio
import com.example.myportfolio.model.PortfolioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 class PortfolioViewModel(private var repository: PortfolioRepository, application: Application) : AndroidViewModel(application) {
    val allPortfolios: LiveData<List<Portfolio>>

    init {
        val portfolioDao = MyDatabase.getDatabase(
            application,
            viewModelScope
        ).portfolioDao()
        repository = PortfolioRepository(portfolioDao)
        allPortfolios = repository.allPortfolio
    }
    fun insertPortfolio(portfolio: Portfolio)= viewModelScope.launch(Dispatchers.IO){
       repository.insertPortfolio(portfolio)

       }

    fun deletePortfolio(portfolio: Portfolio) = viewModelScope.launch(Dispatchers.IO){
        repository.deletePortfolio(portfolio)
    }

     fun updatePortfolio(portfolioId: Long, portfolioItem: String, portfolioCost: String, portfolioDate: String, portfolioTime: String) = viewModelScope.launch(Dispatchers.IO){
        repository.updatePortfolio(portfolioId, portfolioItem, portfolioCost, portfolioTime, portfolioDate)
    }
 }
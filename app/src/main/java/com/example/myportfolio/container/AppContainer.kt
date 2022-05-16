package com.example.myportfolio.container

import android.app.Application
import com.example.myportfolio.model.PortfolioRepository
import com.example.myportfolio.viewmodel.PortfolioViewModel


class AppContainer {
    private val localDataSource = AppContainerInterface()
    private val userRepository = PortfolioRepository(localDataSource)
    val viewModel = PortfolioViewModel(userRepository, Application())
}
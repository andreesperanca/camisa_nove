package com.andreesperanca.camisanove.application

import android.app.Application
import com.andreesperanca.camisanove.AppContainer
import com.andreesperanca.camisanove.AppDataContainer

class App : Application () {


    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }

}
// MyApplication.kt
package com.example.canteen

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory

class MyApplication : Application(), ViewModelStoreOwner {

    override val viewModelStore: ViewModelStore = ViewModelStore()

    lateinit var viewModelProvider: ViewModelProvider
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        viewModelProvider = ViewModelProvider(
            this, AndroidViewModelFactory.getInstance(this)
        )
    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }
}

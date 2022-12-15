package a2a.logistic.app

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class A2ALogisticApplication : Application() {

    companion object {
        var userType = ""

        @JvmName("setUserType1")
        fun setUserType(type: String) {
            userType = type
        }

        @JvmName("getUserType1")
        fun getUserType(): String {
            Log.e("User type", "User type : $userType")
            return userType.uppercase()
        }

    }

    override fun onCreate() {
        super.onCreate()
    }
}
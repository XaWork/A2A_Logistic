package a2a.logistic.app.utils

import a2a.logistic.app.domain.model.usermodel.VerifyOtpModel
import a2a.logistic.app.utils.Constants.PREFERENCE_NAME
import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class UserPreferences @Inject constructor(
    @ApplicationContext private val context: Context
) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
            name = PREFERENCE_NAME
        )
        val USER_TOKEN_KEY = stringPreferencesKey("user_token")
        val USER_KEY = stringPreferencesKey("user")
        val USER_LOGIN = booleanPreferencesKey("user_login")
    }

    /* suspend fun saveUser(user: VerifyOtpModel) {
         context.dataStore.edit { preferences ->
             preferences[USER_KEY] = Gson().toJson(user, VerifyOtpModel::class.java)
         }
     }

     val getUser: Flow<VerifyOtpModel?>
         get() =
             context
                 .dataStore
                 .data
                 .map { preference ->

                     Log.e("Get user", preference[USER_KEY].toString())
                     Gson().fromJson(preference[USER_KEY], VerifyOtpModel::class.java) ?: null
                 }

     suspend fun setLoggedIn(isLoggedIn: Boolean) {
         context.dataStore.edit { preference ->
             preference[USER_LOGIN] = isLoggedIn
         }
     }

     val isLoggedIn: Flow<Boolean> = context
         .dataStore
         .data
         .map { preference ->
             Log.e("isLoggedIn", preference[USER_LOGIN].toString())
             preference[USER_LOGIN] ?: false
         }*/


    //--------------------------------------- Share Preferences ------------------------------------
    private val _myPrefName = "sharePrefName"
    fun saveUser(user: VerifyOtpModel) {
        val editor: SharedPreferences.Editor =
            context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE).edit()
        editor.putString("user", Gson().toJson(user, VerifyOtpModel::class.java))
        Log.d("user", "User saved and user is -> \n$user")
        editor.apply()
    }

    fun getUser(): VerifyOtpModel? {
        val prefs = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
        val userGson = prefs.getString("user", "")
        Log.d("user", "get user is -> \n$userGson")
        return if (TextUtils.isEmpty(userGson))
            null
        else
            Gson().fromJson(userGson, VerifyOtpModel::class.java)
    }

    fun setLoggedIn(isLoggedIn: Boolean) {
        val editor: SharedPreferences.Editor =
            context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE).edit()
        editor.putBoolean("login", isLoggedIn)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        val prefs = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
        val isLoggedIn = prefs.getBoolean("login", false)
        Log.d("user login", " user login -> \n$isLoggedIn")
        return isLoggedIn
    }

    fun logOut(onNavigateToLoginScreen: () -> Unit) {
        val editor = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE).edit()
        editor.clear()
        editor.apply()
        //move to login screen
        onNavigateToLoginScreen()
    }

    fun saveAccessToken(token: String) {
        val editor: SharedPreferences.Editor =
            context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE).edit()
        editor.putString(USER_TOKEN_KEY.toString(), token)
        editor.apply()
    }

    fun getAccessToken(): String {
        val prefs = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
        return prefs.getString(USER_TOKEN_KEY.toString(), "") ?: ""
    }
}
package a2a.logistic.app.presentation.utils

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ViewUtils @Inject constructor(@ApplicationContext private val ctx: Context) {

    fun showShortToast(message: String) {
        Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show()
    }
}
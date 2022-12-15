package a2a.logistic.app.presentation.utils

import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import java.io.File

fun uriToBitmap(context: Context, uri: Uri): Bitmap {
    val bitmap = if (Build.VERSION.SDK_INT < 28)
        MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
    else {
        val source = ImageDecoder.createSource(context.contentResolver, uri)
        ImageDecoder.decodeBitmap(source)
    }

    return bitmap
}

fun uriToFile(context: Context, uri: Uri): File {
    val filePath = arrayOf(MediaStore.Images.Media.DATA)

    val cursor: Cursor = context.contentResolver.query(
        uri,
        filePath,
        null,
        null,
        null
    )!!
    cursor.moveToFirst()
    val columnIndex = cursor.getColumnIndex(filePath[0])
    val picturePath = cursor.getString(columnIndex)
    cursor.close()

    Log.e("image", "file path size is : ${filePath.size}\n$picturePath")

    return File(uri.path!!)
}

fun picturePathToBitmap(picturePath: String): Bitmap {
    return BitmapFactory.decodeFile(picturePath)
}
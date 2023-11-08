package com.andreesperanca.feature_balanced_team.utils

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream


class Image {
    companion object {
        fun saveToGallery(context: Context, bitmap: ImageBitmap?, albumName: String) {
            val filename = "${System.currentTimeMillis()}.png"
            val write: (OutputStream) -> Boolean = {
                bitmap?.asAndroidBitmap()?.compress(Bitmap.CompressFormat.PNG, 100, it)!!
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val contentValues = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
                    put(MediaStore.MediaColumns.MIME_TYPE, "image/png")
                    put(MediaStore.MediaColumns.RELATIVE_PATH, "${Environment.DIRECTORY_DCIM}/$albumName")
                }

                context.contentResolver.let { contentResolver ->
                    contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)?.let { uri ->
                        contentResolver.openOutputStream(uri)?.let(write)
                        shareIntent(context = context, image = uri)
                    }
                }
            } else {
                val imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + File.separator + albumName
                val file = File(imagesDir)
                if (!file.exists()) {
                    file.mkdir()
                }
                val image = File(imagesDir, filename)
                write(FileOutputStream(image))
                shareIntent(context = context, image = Uri.fromFile(image))
            }
        }
        private fun shareIntent(context: Context, image: Uri) {
            val shareIntent: Intent = Intent().apply {
                addFlags(FLAG_ACTIVITY_NEW_TASK,)
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, image)
                type = "image/jpeg"
            }
            context.startActivity(
                Intent.createChooser(
                    shareIntent, "andre"
                )
            )
        }
    }
}
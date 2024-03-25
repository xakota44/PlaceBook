package com.raywenderlich.placebook.model

import android.content.Context
import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import util.FileUtils
import util.ImageUtils

// 1
@Entity
// 2
data class Bookmark(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    var placeId: String? = null,
    var name: String = "",
    var address: String = "",
    var latitude: Double = 0.0,
    var longitude: Double = 0.0,
    var phone: String = "",
    var notes: String = "",
    var category: String = ""
)
{
    // 1
    fun setImage(image: Bitmap, context: Context) {
        // 2
        id?.let {
            ImageUtils.saveBitmapToFile(context, image,
                generateImageFilename(it))
        }
    }
    fun deleteImage(context: Context) {
        id?.let {
            FileUtils.deleteFile(context, generateImageFilename(it))
        }
    }
    //3
    companion object {
        fun generateImageFilename(id: Long): String {
            // 4
            return "bookmark$id.png"
        }
    }
}


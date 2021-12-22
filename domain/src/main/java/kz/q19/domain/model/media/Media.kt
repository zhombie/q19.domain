package kz.q19.domain.model.media

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.garage.file.extension.Extension
import kz.q19.domain.model.file.LocalFile

// TODO: Divide into separate classes, like Image, Audio, which would inherit base Media class
@Deprecated("Use Media2")
@Keep
@Parcelize
data class Media constructor(
    val id: String,
    val type: Type? = null,
    val title: String? = null,
    val extension: Extension? = null,
    val width: Int? = null,
    val height: Int? = null,
    val duration: Long? = null,  // milliseconds
    val dateAdded: Long? = null,  // milliseconds
    val dateModified: Long? = null,  // milliseconds
    val dateTaken: Long? = null,  // milliseconds
    val size: Long? = null,

    // Server url path
    val urlPath: String? = null,

    // Local file
    var file: LocalFile? = null
) : Parcelable {

    @Keep
    @Parcelize
    enum class Type constructor(val key: String) : Parcelable {
        IMAGE("image"),
        AUDIO("audio"),
        VIDEO("video"),
        DOCUMENT("document"),
        FILE("file")
    }

    fun hasLocalFile(): Boolean =
        file?.isExist() == true

}
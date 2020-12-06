@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize
import kz.q19.domain.R
import kz.q19.utils.file.Extension

@Keep
@Parcelize
data class Media constructor(
    val id: Int,
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
    var file: File? = null
) : Parcelable {

    @Keep
    enum class Type(val key: String) {
        IMAGE("image"),
        AUDIO("audio"),
        VIDEO("video"),
        DOCUMENT("document"),
        FILE("file")
    }

    val representation: Int
        @StringRes
        get() = if (type == Type.FILE) {
            when (extension) {
                Extension.TXT -> R.string.text_file
                Extension.DOC, Extension.DOCX -> R.string.microsoft_word_document
                Extension.XLS, Extension.XLSX -> R.string.microsoft_excel_document
                Extension.PDF -> R.string.pdf_file
                Extension.HTML -> R.string.html_text
                else -> R.string.file
            }
        } else {
            -1
        }

    fun hasLocalFile(): Boolean {
        return file?.get()?.exists() == true
    }

}
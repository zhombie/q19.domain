@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.annotation.StringRes
import kotlinx.android.parcel.Parcelize
import kz.q19.domain.R
import kz.q19.utils.file.Extension

@Keep
@Parcelize
data class Attachment constructor(
    val title: String? = null,
    val extension: Extension? = null,
    val type: Type? = null,
    val urlPath: String? = null,
    var file: File? = null
) : Parcelable {

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

    override fun toString(): String {
        return super.toString()
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

}
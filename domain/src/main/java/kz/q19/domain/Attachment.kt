package kz.q19.domain

import android.os.Parcelable
import androidx.annotation.StringRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Attachment constructor(
    val title: String? = null,
    val extension: Extension? = null,
    val type: Type? = null,
    val urlPath: String? = null
) : Parcelable {

    enum class Type(val key: String) {
        IMAGE("image"),
        AUDIO("audio"),
        VIDEO("video"),
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

}
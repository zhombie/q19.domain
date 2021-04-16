package kz.q19.domain.model.media

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize
import kz.q19.domain.R
import kz.q19.domain.model.file.Extension

@Keep
@Parcelize
enum class Type constructor(val key: String) : Parcelable {
    IMAGE("image"),
    AUDIO("audio"),
    VIDEO("video"),
    DOCUMENT("document"),
    FILE("file")
}

fun Media2.toStringType(): String? {
    val type = when (this) {
        is Image -> Type.IMAGE
        is Video -> Type.VIDEO
        is Audio -> Type.AUDIO
        else -> null
    }
    return type?.key
}


@StringRes
fun Media2.getDisplayRepresentation(): Int {
    return when (properties?.extension) {
        Extension.TXT -> R.string.text_file
        Extension.DOC, Extension.DOCX -> R.string.microsoft_word_document
        Extension.XLS, Extension.XLSX -> R.string.microsoft_excel_document
        Extension.PDF -> R.string.pdf_file
        Extension.HTML -> R.string.html_text
        else -> R.string.file
    }
}
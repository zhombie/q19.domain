package kz.q19.domain.model.file

import androidx.annotation.Keep

@Keep
enum class Extensions constructor(val values: Set<Extension>) {
    IMAGE(setOf(Extension.JPG, Extension.JPEG, Extension.PNG)),
    AUDIO(setOf(Extension.MP3, Extension.WAV, Extension.OPUS, Extension.OGG)),
    VIDEO(setOf(Extension.MP4, Extension.MOV, Extension.WEBM, Extension.MKV, Extension.AVI)),
    DOCUMENT(setOf(Extension.DOC, Extension.DOCX, Extension.XLS, Extension.XLSX, Extension.PDF))
}
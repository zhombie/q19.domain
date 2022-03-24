package kz.q19.domain.model.content

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class ContentType constructor(val key: String) : Parcelable {
    IMAGE("image"),
    VIDEO("video"),
    AUDIO("audio"),
    DOCUMENT("document");

    companion object {
        fun from(key: String?): ContentType? = when (key) {
            IMAGE.key -> IMAGE
            VIDEO.key -> VIDEO
            AUDIO.key -> AUDIO
            DOCUMENT.key -> DOCUMENT
            else -> null
        }
    }
}
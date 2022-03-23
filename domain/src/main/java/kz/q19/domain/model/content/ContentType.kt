package kz.q19.domain.model.content

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class ContentType constructor(val key: String) : Parcelable {
    IMAGE("image"),
    VIDEO("video"),
    AUDIO("audio"),
    DOCUMENT("document"),
    FILE("file")
}
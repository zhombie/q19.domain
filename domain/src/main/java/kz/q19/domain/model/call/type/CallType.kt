package kz.q19.domain.model.call.type

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
enum class CallType constructor(private val value: String) : Parcelable {
    TEXT("text"),
    AUDIO("audio"),
    VIDEO("video");

    companion object {
        fun from(value: String): CallType? =
            when (value) {
                TEXT.value -> TEXT
                AUDIO.value -> AUDIO
                VIDEO.value -> VIDEO
                else -> null
            }
    }

    fun getValue(): String = value
}
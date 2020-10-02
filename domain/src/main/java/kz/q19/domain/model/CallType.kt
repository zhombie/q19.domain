@file:Suppress("unused")

package kz.q19.domain.model

import androidx.annotation.Keep

@Keep
enum class CallType {
    TEXT,
    AUDIO,
    VIDEO
}
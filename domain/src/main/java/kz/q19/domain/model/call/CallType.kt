package kz.q19.domain.model.call

import androidx.annotation.Keep

@Keep
enum class CallType {
    TEXT,
    AUDIO,
    VIDEO
}
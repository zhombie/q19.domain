package kz.q19.domain.model.call

import androidx.annotation.Keep

@Deprecated("Use Call.Text, Call.Audio, Call.Video")
@Keep
enum class CallType {
    TEXT,
    AUDIO,
    VIDEO
}
package kz.q19.domain.model.message

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
enum class QRTCAction constructor(val value: String) : Parcelable {
    START("start"),
    PREPARE("prepare"),
    READY("ready"),
    OFFER("offer"),
    ANSWER("answer"),
    CANDIDATE("candidate"),
    HANGUP("hangup");

    override fun toString(): String = value
}
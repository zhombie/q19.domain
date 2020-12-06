@file:Suppress("unused")

package kz.q19.domain.model.webrtc

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class WebRTCInfo constructor(
    val type: Type,
    val sdp: String? = null,
    val id: String? = null,
    val label: Int? = null,
    val candidate: String? = null
) : Parcelable {

    @Keep
    enum class Type(val value: String) {
        START("start"),
        PREPARE("prepare"),
        READY("ready"),
        OFFER("offer"),
        ANSWER("answer"),
        CANDIDATE("candidate"),
        HANGUP("hangup");

        companion object {
            fun by(type: SessionDescription.Type): Type {
                return when (type) {
                    SessionDescription.Type.OFFER -> OFFER
                    SessionDescription.Type.ANSWER -> ANSWER
                }
            }

            fun by(type: String): SessionDescription.Type? {
                return when (type) {
                    OFFER.value -> SessionDescription.Type.OFFER
                    ANSWER.value -> SessionDescription.Type.ANSWER
                    else -> null
                }
            }
        }

        override fun toString(): String = value
    }

}
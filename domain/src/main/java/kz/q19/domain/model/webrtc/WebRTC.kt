@file:Suppress("unused")

package kz.q19.domain.model.webrtc

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class WebRTC constructor(
    val type: Type,
    val sdp: String? = null,
    val id: String? = null,
    val label: Int? = null,
    val candidate: String? = null
) : Parcelable {

    enum class Type(val value: String) {
        START("start"),
        PREPARE("prepare"),
        READY("ready"),
        OFFER("offer"),
        ANSWER("answer"),
        CANDIDATE("candidate"),
        HANGUP("hangup");

        companion object {
            fun by(type: WebRTCSessionDescription.Type): Type {
                return when (type) {
                    WebRTCSessionDescription.Type.OFFER -> OFFER
                    WebRTCSessionDescription.Type.ANSWER -> ANSWER
                }
            }

            fun by(type: String): WebRTCSessionDescription.Type? {
                return when (type) {
                    OFFER.value -> WebRTCSessionDescription.Type.OFFER
                    ANSWER.value -> WebRTCSessionDescription.Type.ANSWER
                    else -> null
                }
            }
        }

        override fun toString(): String {
            return value
        }
    }

}
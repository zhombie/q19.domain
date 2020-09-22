@file:Suppress("unused")

package kz.q19.domain.webrtc

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WebRTC(
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

        override fun toString(): String {
            return value
        }
    }

}
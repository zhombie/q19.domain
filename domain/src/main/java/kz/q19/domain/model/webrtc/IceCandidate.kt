@file:Suppress("unused")

package kz.q19.domain.model.webrtc

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IceCandidate constructor(
    val sdpMid: String,
    val sdpMLineIndex: Int,
    val sdp: String,
    val serverUrl: String = "",
    val adapterType: AdapterType = AdapterType.UNKNOWN,
) : Parcelable {

    constructor(
        sdpMid: String,
        sdpMLineIndex: Int,
        sdp: String
    ) : this(
        sdpMid = sdpMid,
        sdpMLineIndex = sdpMLineIndex,
        sdp = sdp,
        serverUrl = EMPTY_SERVER_URL,
        adapterType = AdapterType.UNKNOWN
    )

    companion object {
        const val EMPTY_SERVER_URL = ""
    }

}
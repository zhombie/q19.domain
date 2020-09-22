@file:Suppress("unused")

package kz.q19.domain.webrtc

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IceCandidate(
    val sdpMid: String,
    val sdpMLineIndex: Int,
    val sdp: String,
    val serverUrl: String = "",
    val adapterType: AdapterType = AdapterType.UNKNOWN,
) : Parcelable
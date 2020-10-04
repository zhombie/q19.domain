@file:Suppress("unused")

package kz.q19.domain.model.webrtc

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class WebRTCIceCandidate constructor(
    val sdpMid: String,
    val sdpMLineIndex: Int,
    val sdp: String,
    val serverUrl: String? = null,
    val adapterType: WebRTCAdapterType = WebRTCAdapterType.UNKNOWN,
) : Parcelable {

    companion object {
        val NO_SERVER_URL = null
    }

}
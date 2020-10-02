@file:Suppress("unused")

package kz.q19.domain.model.webrtc

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class WebRTCSessionDescription constructor(
    val type: Type,
    val description: String
) : Parcelable {

    enum class Type {
        OFFER,
        ANSWER
    }

}
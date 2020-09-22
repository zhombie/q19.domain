package kz.q19.domain.webrtc

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SessionDescription(
    val type: Type,
    val description: String
) : Parcelable {

    enum class Type {
        OFFER,
        ANSWER
    }

}
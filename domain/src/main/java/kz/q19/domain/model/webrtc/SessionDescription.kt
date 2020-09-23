@file:Suppress("unused")

package kz.q19.domain.model.webrtc

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SessionDescription constructor(
    val type: Type,
    val description: String
) : Parcelable {

    enum class Type {
        OFFER,
        ANSWER
    }

}
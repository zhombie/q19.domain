@file:Suppress("unused")

package kz.q19.domain.model.webrtc

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IceServer constructor(
    val url: String?,
    val username: String? = null,
    val urls: String?,
    val credential: String? = null
) : Parcelable
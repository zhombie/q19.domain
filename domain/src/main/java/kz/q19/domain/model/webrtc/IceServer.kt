package kz.q19.domain.model.webrtc

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class IceServer constructor(
    val url: String,
    val urls: String,
    val username: String? = null,
    val credential: String? = null
) : Parcelable
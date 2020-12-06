@file:Suppress("unused")

package kz.q19.domain.model.webrtc

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class IceServer constructor(
    @SerializedName("url")
    val url: String?,

    @SerializedName("urls")
    val urls: String?,

    @SerializedName("username")
    val username: String? = "",

    @SerializedName("credential")
    val credential: String? = ""
) : Parcelable
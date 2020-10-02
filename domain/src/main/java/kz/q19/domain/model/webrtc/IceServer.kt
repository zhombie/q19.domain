@file:Suppress("unused")

package kz.q19.domain.model.webrtc

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class IceServer(
    @SerializedName("url")
    val url: String?,

    @SerializedName("urls")
    val urls: String?,

    @SerializedName("username")
    val username: String? = null,

    @SerializedName("credential")
    val credential: String? = null
) : Parcelable
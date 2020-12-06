@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kz.q19.domain.model.webrtc.IceServer

@Keep
@Parcelize
data class IceServersResponse constructor(
    @SerializedName("ice_servers")
    val iceServers: List<IceServer>? = null
) : Parcelable
@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Location constructor(
    @SerializedName("provider")
    val provider: String? = null,

    @SerializedName("lat")
    val latitude: Double,

    @SerializedName("lon")
    val longitude: Double,

    @SerializedName("bearing")
    val bearing: Float? = null,

    @SerializedName("bearing_accuracy_degrees")
    val bearingAccuracyDegrees: Float? = null,

    @SerializedName("x_accuracy_meters")
    val xAccuracyMeters: Float? = null,

    @SerializedName("y_accuracy_meters")
    val yAccuracyMeters: Float? = null,

    @SerializedName("speed")
    val speed: Float? = null,

    @SerializedName("speed_accuracy_meters_per_second")
    val speedAccuracyMetersPerSecond: Float? = null
) : Parcelable
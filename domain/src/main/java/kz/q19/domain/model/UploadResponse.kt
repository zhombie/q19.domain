@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class UploadResponse constructor(
    @SerializedName("hash")
    val hash: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String
) : Parcelable
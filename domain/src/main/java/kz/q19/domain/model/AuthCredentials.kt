@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class AuthCredentials constructor(
    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String
) : Parcelable
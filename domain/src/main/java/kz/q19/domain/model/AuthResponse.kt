@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class AuthResponse constructor(
    @SerializedName("user_id")
    val userId: Long,

    @SerializedName("token")
    val token: String,

    @SerializedName("_success")
    val _success: Boolean
) : Parcelable
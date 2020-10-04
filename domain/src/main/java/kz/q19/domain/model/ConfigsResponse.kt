package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class ConfigsResponse(
    @SerializedName("configs")
    val configs: Configs? = null,

    @SerializedName("booleans")
    val booleans: Booleans? = null,

    @SerializedName("call_scopes")
    val callScopes: List<CallScope>? = null
) : Parcelable
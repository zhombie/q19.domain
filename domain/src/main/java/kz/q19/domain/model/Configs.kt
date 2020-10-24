package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Configs constructor(
    @SerializedName("title")
    val title: String? = null,

    @SerializedName("bgcolor")
    val bgColor: String? = null,

    @SerializedName("image")
    val image: String? = null,

    @SerializedName("default_operator")
    val defaultOperator: String? = null,

    @SerializedName("type")
    val type: Int? = null
) : Parcelable
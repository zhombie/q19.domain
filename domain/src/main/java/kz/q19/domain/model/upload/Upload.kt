package kz.q19.domain.model.upload

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Upload constructor(
    val hash: String,
    val title: String,
    val url: String
) : Parcelable
package kz.q19.domain.model.user

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class User constructor(
    val userId: Long,
    val token: String
) : Parcelable
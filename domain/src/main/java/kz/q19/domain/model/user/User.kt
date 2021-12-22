package kz.q19.domain.model.user

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

// TODO: Divide into classes: System & Client; Make more detailed properties
@Deprecated("It doesn't provide required definition")
@Keep
@Parcelize
data class User constructor(
    val userId: Long,
    val token: String
) : Parcelable
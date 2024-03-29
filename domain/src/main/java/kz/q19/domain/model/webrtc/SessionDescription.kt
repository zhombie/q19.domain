package kz.q19.domain.model.webrtc

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class SessionDescription constructor(
    val type: Type,
    val description: String
) : Parcelable {

    @Keep
    @Parcelize
    enum class Type : Parcelable {
        OFFER,
        ANSWER
    }

}
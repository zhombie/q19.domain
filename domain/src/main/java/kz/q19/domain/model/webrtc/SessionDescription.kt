package kz.q19.domain.model.webrtc

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.message.QRTCAction

@Keep
@Parcelize
data class SessionDescription constructor(
    val type: Type,
    val description: String
) : Parcelable {

    @Keep
    enum class Type {
        OFFER,
        ANSWER
    }

}
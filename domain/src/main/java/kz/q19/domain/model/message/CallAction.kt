package kz.q19.domain.model.message

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
enum class CallAction constructor(val value: String) : Parcelable {
    CALL_ACCEPT("call_accept"),
    CALL_REDIAL("call_redial"),
    CALL_REDIRECT("call_redirect"),
    CHAT_TIMEOUT("chat_timeout"),
    FINISH("finish"),
    REDIRECT("redirect"),
    OPERATOR_DISCONNECT("operator_disconnect");

    override fun toString(): String = value
}
@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import android.text.Spanned
import android.text.format.DateFormat
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.webrtc.WebRTCInfo
import kz.q19.utils.html.HTMLCompat
import java.util.*

@Keep
@Parcelize
data class Message constructor(
    val id: String? = null,
    val type: Type,
    val text: String? = null,
    val replyMarkup: ReplyMarkup? = null,
    val media: Media? = null,
    val attachments: List<Media>? = null,
    val date: Calendar = now(),

    val category: Category? = null,

    val form: Form? = null,

    val webRTCInfo: WebRTCInfo? = null,

    val action: Action? = null
) : Parcelable {

    companion object {
        fun fromTimestamp(timestamp: Long): Calendar {
            val calendar = Calendar.getInstance()
            if (timestamp == 0L) {
                return calendar
            }
            calendar.timeInMillis = timestamp * 1000L
            return calendar
        }

        fun now(): Calendar {
            return Calendar.getInstance()
        }

        fun parseDate(calendar: Calendar): String {
            return DateFormat.format("HH:MM", calendar).toString()
        }
    }

    constructor(
        id: String? = null,
        type: Type,
        text: String? = null,
        replyMarkup: ReplyMarkup? = null,
        media: Media? = null,
        attachments: List<Media>? = null,
        timestamp: Long? = null,
        category: Category? = null,
        form: Form? = null,
        webRTCInfo: WebRTCInfo? =null,
        action: Action? = null
    ) : this(
        id = id,
        type = type,
        text = text?.trim(),
        replyMarkup = replyMarkup,
        media = media,
        attachments = attachments,
        date = timestamp?.let { fromTimestamp(it) } ?: now(),
        category = category,
        form = form,
        webRTCInfo = webRTCInfo,
        action = action
    )

    val time: String
        get() = parseDate(date)

    val htmlText: Spanned?
        get() {
            return if (text.isNullOrBlank()) {
                null
            } else {
                val text = text.replace("(<br>|<br/>)*$".toRegex(), "")
                HTMLCompat.fromHtml(text)
            }
        }

    @Keep
    enum class Type {
        OUTGOING,
        INCOMING,

        NOTIFICATION,

        TYPING,

        CATEGORY,
        CROSS_CHILDREN,
        RESPONSE
    }

    @Keep
    enum class Action constructor(val value: String) {
        CALL_ACCEPT("call_accept"),
        CALL_REDIAL("call_redial"),
        CALL_REDIRECT("call_redirect"),
        CHAT_TIMEOUT("chat_timeout"),
        FINISH("finish"),
        REDIRECT("redirect"),
        OPERATOR_DISCONNECT("operator_disconnect");

        override fun toString(): String {
            return value
        }
    }

}
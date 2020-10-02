@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import android.text.Spanned
import android.text.format.DateFormat
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize
import kz.q19.domain.model.webrtc.WebRTC
import kz.q19.utils.html.HTMLCompat
import java.util.*

@Keep
@Parcelize
data class Message constructor(
    val id: String? = null,
    val type: Type,
    val text: String? = null,
    val replyMarkup: ReplyMarkup? = null,
    val attachments: List<Attachment>? = null,
    val date: Calendar = now(),

    val category: Category? = null,

    val form: Form? = null,

    val webRTC: WebRTC? = null,

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
        attachments: List<Attachment>? = null,
        timestamp: Long? = null,
        category: Category? = null,
        form: Form? = null,
        webRTC: WebRTC? =null,
        action: Action? = null
    ) : this(
        id = id,
        type = type,
        text = text?.trim(),
        replyMarkup = replyMarkup,
        attachments = attachments,
        date = timestamp?.let { fromTimestamp(it) } ?: now(),
        category = category,
        form = form,
        webRTC = webRTC,
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

    @Parcelize
    data class ReplyMarkup constructor(
        val rows: List<List<Button>> = emptyList()
    ) : Parcelable {

        @Parcelize
        data class Button constructor(
            val text: String,
            val callbackData: String? = null,
            val url: String? = null
        ) : Parcelable

        fun getAllButtons(): MutableList<Button> {
            val buttons = mutableListOf<Button>()
            rows.forEach {
                it.forEach { button ->
                    buttons.add(button)
                }
            }
            return buttons
        }

        fun getColumnsCount(): Int {
            return if (rows.isNullOrEmpty()) {
                0
            } else {
                rows.first().size
            }
        }

    }

    enum class Type {
        OUTGOING,
        INCOMING,

        NOTIFICATION,

        TYPING,

        CATEGORY,
        CROSS_CHILDREN,
        RESPONSE
    }

    enum class Action(val value: String) {
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
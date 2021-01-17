package kz.q19.domain.model.message

import android.os.Build
import android.os.Parcelable
import android.text.Html
import android.text.Spanned
import android.text.format.DateFormat
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.media.Media
import kz.q19.domain.model.keyboard.Keyboard
import java.util.*

@Keep
@Parcelize
data class Message constructor(
    val id: String? = null,
    val type: Type,
    val text: String? = null,
    val keyboard: Keyboard? = null,
    val media: Media? = null,
    val attachments: List<Media>? = null,
    val createdAt: Calendar = now(),
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
        keyboard: Keyboard? = null,
        media: Media? = null,
        attachments: List<Media>? = null,
        timestamp: Long? = null
    ) : this(
        id = id,
        type = type,
        text = text?.trim(),
        keyboard = keyboard,
        media = media,
        attachments = attachments,
        createdAt = timestamp?.let { fromTimestamp(it) } ?: now()
    )

    val time: String
        get() = parseDate(createdAt)

    val htmlText: Spanned?
        get() {
            val text = text
            return if (!text.isNullOrBlank()) {
                val clearedText = text.replace("(<br>|<br/>)*$".toRegex(), "")
                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml(clearedText, Html.FROM_HTML_MODE_COMPACT)
                } else {
                    Html.fromHtml(clearedText)
                }
            } else {
                null
            }
        }

    @Keep
    @Parcelize
    enum class Type : Parcelable {
        OUTGOING,
        INCOMING,

        NOTIFICATION,

        TYPING,

        CATEGORY,
        CROSS_CHILDREN,
        RESPONSE
    }

}
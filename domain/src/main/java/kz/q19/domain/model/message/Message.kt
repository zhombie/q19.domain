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
data class Message internal constructor(
    val id: String? = Default.ID,
    val type: Type,
    val text: String? = Default.TEXT,
    val keyboard: Keyboard? = Default.KEYBOARD,
    val media: Media? = Default.MEDIA,
    val attachments: List<Media>? = Default.ATTACHMENTS,
    val createdAt: Long = Default.CREATED_AT,
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

        fun parseDate(timestamp: Long): String {
            return parseDate(fromTimestamp(timestamp))
        }

        fun parseDate(calendar: Calendar): String {
            return DateFormat.format("HH:MM", calendar).toString()
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

    private object Default {
        val ID: String? = null
        val TEXT: String? = null
        val KEYBOARD: Keyboard? = null
        val MEDIA: Media? = null
        val ATTACHMENTS: List<Media>? = null
        val CREATED_AT: Long = now().timeInMillis
    }

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

    class Builder {
        private var id: String? = Default.ID
        private var type: Type? = null
        private var text: String? = Default.TEXT
        private var keyboard: Keyboard? = Default.KEYBOARD
        private var media: Media? = Default.MEDIA
        private var attachments: List<Media>? = Default.ATTACHMENTS
        private var createdAt: Long = Default.CREATED_AT

        fun getId(): String? {
            return id
        }

        fun setId(id: String): Builder {
            this.id = id
            return this
        }

        fun getType(): Type? {
            return type
        }

        fun setType(type: Type): Builder {
            this.type = type
            return this
        }

        fun getText(): String? {
            return text
        }

        fun setText(text: String): Builder {
            this.text = text
            return this
        }

        fun getKeyboard(): Keyboard? {
            return keyboard
        }

        fun setKeyboard(keyboard: Keyboard): Builder {
            this.keyboard = keyboard
            return this
        }

        fun getMedia(): Media? {
            return media
        }

        fun setMedia(media: Media): Builder {
            this.media = media
            return this
        }

        fun getAttachments(): List<Media>? {
            return attachments
        }

        fun setAttachments(attachments: List<Media>): Builder {
            this.attachments = attachments
            return this
        }

        fun getCreatedAt(): Long {
            return createdAt
        }

        fun setCreatedAt(createdAt: Long): Builder {
            this.createdAt = createdAt
            return this
        }

        fun setCreatedAt(createdAt: Calendar): Builder {
            this.createdAt = createdAt.timeInMillis
            return this
        }

        fun build(): Message {
            return Message(
                id = id,
                type = requireNotNull(type) { "message.type cannot be null. Declare it at first" },
                text = text,
                keyboard = keyboard,
                media = media,
                attachments = attachments,
                createdAt = createdAt
            )
        }

    }

}
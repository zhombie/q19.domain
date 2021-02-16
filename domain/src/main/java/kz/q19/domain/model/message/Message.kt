package kz.q19.domain.model.message

import android.os.Build
import android.os.Parcelable
import android.text.Html
import android.text.Spanned
import android.text.format.DateFormat
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.geo.Location
import kz.q19.domain.model.keyboard.Keyboard
import kz.q19.domain.model.media.Media
import java.util.*

@Keep
@Parcelize
data class Message internal constructor(
    val id: String? = Default.ID,
    val type: Type,
    val title: String? = Default.TITLE,
    val text: String? = Default.TEXT,
    val createdAt: Long = Default.CREATED_AT,
    val keyboard: Keyboard? = Default.KEYBOARD,
    val media: Media? = Default.MEDIA,
    val attachments: List<Media>? = Default.ATTACHMENTS,
    val location: Location? = Default.LOCATION
) : Parcelable {

    companion object {
        fun fromTimestamp(
            timestamp: Long,
            timezone: TimeZone = TimeZone.getDefault(),
            locale: Locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Locale.getDefault(Locale.Category.FORMAT)
            } else {
                Locale.getDefault()
            }
        ): Calendar {
            val calendar = Calendar.getInstance(timezone, locale)
            if (timestamp == 0L) {
                return calendar
            }
            calendar.timeInMillis = timestamp * 1000L
            return calendar
        }

        fun now(
            timezone: TimeZone = TimeZone.getDefault(),
            locale: Locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Locale.getDefault(Locale.Category.FORMAT)
            } else {
                Locale.getDefault()
            }
        ): Calendar {
            return Calendar.getInstance(timezone, locale)
        }

        fun parseDate(
            timestamp: Long,
            timezone: TimeZone = TimeZone.getDefault(),
            locale: Locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Locale.getDefault(Locale.Category.FORMAT)
            } else {
                Locale.getDefault()
            }
        ): String {
            return parseDate(fromTimestamp(timestamp, timezone, locale))
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

        NOTIFICATION
    }

    private object Default {
        val ID: String? = null
        val TITLE: String? = null
        val TEXT: String? = null
        val CREATED_AT: Long = now().timeInMillis
        val KEYBOARD: Keyboard? = null
        val MEDIA: Media? = null
        val ATTACHMENTS: List<Media>? = null
        val LOCATION: Location? = null
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
                    @Suppress("DEPRECATION")
                    Html.fromHtml(clearedText)
                }
            } else {
                null
            }
        }

    class Builder {
        private var id: String? = Default.ID
        private var type: Type? = null
        private var title: String? = Default.TITLE
        private var text: String? = Default.TEXT
        private var createdAt: Long = Default.CREATED_AT
        private var keyboard: Keyboard? = Default.KEYBOARD
        private var media: Media? = Default.MEDIA
        private var attachments: List<Media>? = Default.ATTACHMENTS
        private var location: Location? = Default.LOCATION

        fun getId(): String? {
            return id
        }

        fun setId(id: String?): Builder {
            this.id = id
            return this
        }

        fun resetId(): Builder {
            this.id = Default.ID
            return this
        }

        fun getType(): Type? {
            return type
        }

        fun setType(type: Type?): Builder {
            this.type = type
            return this
        }

        fun resetType(): Builder {
            this.type = null
            return this
        }

        fun getTitle(): String? {
            return title
        }

        fun setTitle(title: String?): Builder {
            this.title = title
            return this
        }

        fun resetTitle(): Builder {
            this.title = Default.TITLE
            return this
        }

        fun getText(): String? {
            return text
        }

        fun setText(text: String?): Builder {
            this.text = text
            return this
        }

        fun resetText(): Builder {
            this.text = Default.TEXT
            return this
        }

        fun getKeyboard(): Keyboard? {
            return keyboard
        }

        fun getCreatedAt(): Long {
            return createdAt
        }

        fun setCreatedAt(createdAt: Long?): Builder {
            return if (createdAt == null) {
                this.createdAt = Default.CREATED_AT
                this
            } else {
                this.createdAt = createdAt
                this
            }
        }

        fun setCreatedAt(createdAt: Calendar?): Builder {
            return if (createdAt == null) {
                this.createdAt = Default.CREATED_AT
                this
            } else {
                this.createdAt = createdAt.timeInMillis
                this
            }
        }

        fun resetCreatedAt(): Builder {
            this.createdAt = Default.CREATED_AT
            return this
        }

        fun setKeyboard(keyboard: Keyboard?): Builder {
            this.keyboard = keyboard
            return this
        }

        fun resetKeyboard(): Builder {
            this.keyboard = Default.KEYBOARD
            return this
        }

        fun getMedia(): Media? {
            return media
        }

        fun setMedia(media: Media?): Builder {
            this.media = media
            return this
        }

        fun resetMedia(): Builder {
            this.media = Default.MEDIA
            return this
        }

        fun getAttachments(): List<Media>? {
            return attachments
        }

        fun setAttachments(attachments: List<Media>?): Builder {
            this.attachments = attachments
            return this
        }

        fun resetAttachments(): Builder {
            this.attachments = Default.ATTACHMENTS
            return this
        }

        fun getLocation(): Location? {
            return location
        }

        fun setLocation(location: Location?): Builder {
            this.location = location
            return this
        }

        fun resetLocation(): Builder {
            this.location = Default.LOCATION
            return this
        }

        fun build(): Message {
            return Message(
                id = id,
                type = requireNotNull(type) { "message.type cannot be null. Declare it at first" },
                text = text,
                createdAt = createdAt,
                keyboard = keyboard,
                media = media,
                attachments = attachments,
                location = location
            )
        }

    }

}
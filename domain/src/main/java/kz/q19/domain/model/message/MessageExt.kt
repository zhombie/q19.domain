package kz.q19.domain.model.message

import android.os.Build
import android.text.Html
import android.text.Spanned
import android.text.format.DateFormat
import kz.garage.chat.model.Message
import java.util.*

val Message.asHTMLText: Spanned?
    get() = if (body.isNullOrBlank()) {
        null
    } else {
        val clearedText = body?.replace("(<br>|<br/>)*$".toRegex(), "")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(clearedText, Html.FROM_HTML_MODE_COMPACT)
        } else {
            @Suppress("DEPRECATION")
            Html.fromHtml(clearedText)
        }
    }

fun Message.getDisplayCreatedAt(
    inFormat: String = "HH:MM",
    locale: Locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Locale.getDefault(Locale.Category.FORMAT)
    } else {
        Locale.getDefault()
    },
    timeZone: TimeZone = TimeZone.getDefault(),
    convertToMillis: Boolean = true
): String? {
    val createdAt = createdAt ?: return null
    if (createdAt == 0L) return null
    return DateFormat.format(
        inFormat,
        Calendar.getInstance(timeZone, locale).apply {
            timeInMillis = if (convertToMillis) createdAt * 1000L else createdAt
        }
    ).toString()
}

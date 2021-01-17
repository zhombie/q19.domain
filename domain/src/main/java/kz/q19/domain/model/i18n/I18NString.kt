package kz.q19.domain.model.i18n

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.language.Language
import java.util.*

@Keep
@Parcelize
data class I18NString constructor(
    val kk: String? = null,
    val ru: String? = null,
    val en: String? = null
) : Parcelable {

    companion object {
        val NOT_FOUND: I18NString
            get() = I18NString(
                en = "Nothing found :(",
                ru = "Ничего не найдено :(",
                kk = "Ештеңе табылмады :("
            )
    }

    fun get(language: Language? = null): String? {
        return when (language?.key ?: Language.from(Locale.getDefault()).key) {
            Language.KAZAKH.key -> kk
            Language.RUSSIAN.key -> ru
            Language.ENGLISH.key -> en
            else -> ru
        }
    }

}
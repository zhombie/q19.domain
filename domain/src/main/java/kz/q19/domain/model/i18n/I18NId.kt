package kz.q19.domain.model.i18n

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.language.Language
import java.util.*

@Keep
@Parcelize
data class I18NId constructor(
    val kk: Long?,
    val ru: Long?,
    val en: Long?
) : Parcelable {

    fun get(language: Language? = null): Long? {
        return when (language?.key ?: Language.from(Locale.getDefault()).key) {
            Language.KAZAKH.key -> kk
            Language.RUSSIAN.key -> ru
            Language.ENGLISH.key -> en
            else -> ru
        }
    }

}
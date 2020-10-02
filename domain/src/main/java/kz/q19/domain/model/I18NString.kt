@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Keep
@Parcelize
data class I18NString(
    @SerializedName("kk")
    val kk: String? = null,

    @SerializedName("kz")
    val kz: String? = null,

    @SerializedName("ru")
    val ru: String? = null,

    @SerializedName("en")
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
            Language.KAZAKH.key -> kk ?: kz
            Language.RUSSIAN.key -> ru
            Language.ENGLISH.key -> en
            else -> ru
        }
    }

}
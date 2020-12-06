@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.utils.enums.findEnumBy
import java.util.*

@Keep
@Parcelize
data class Language constructor(
    val key: String,
    val representation: String,
    val id: Long
) : Parcelable {

    companion object {
        val DEFAULT: Language
            get() = by(Locale.getDefault().language)

        val KAZAKH: Language
            get() = Language(Key.KK, Representation.KK, ID.KK)

        val RUSSIAN: Language
            get() = Language(Key.RU, Representation.RU, ID.RU)

        val ENGLISH: Language
            get() = Language(Key.EN, Representation.EN, ID.EN)

        fun getSupportedLanguages(): Array<Language> {
            return arrayOf(KAZAKH, RUSSIAN)
        }

        fun from(locale: Locale): Language {
            return by(locale.language)
        }

        fun by(key: String): Language {
            return when (key) {
                Key.KK.value -> KAZAKH
                Key.RU.value -> RUSSIAN
//                Key.ENGLISH.value -> ENGLISH
                else -> RUSSIAN
            }
        }
    }

    @Keep
    enum class Key(val value: String) {
        KK("kk"),
        RU("ru"),
        EN("en")
    }

    @Keep
    enum class Representation(val value: String) {
        KK("Қаз"),
        RU("Рус"),
        EN("Eng")
    }

    @Keep
    enum class ID(val value: Long) {
        KK(2),
        RU(1),
        EN(3);

        companion object {
            fun by(value: Long) : ID {
                return findEnumBy { it.value == value } ?: RU
            }
        }
    }

    constructor(
        key: Key,
        representation:
        Representation, id: ID
    ) : this(key = key.value, representation = representation.value, id = id.value)

    val locale: Locale
        get() = Locale(key)

    override fun toString(): String {
        return key
    }

}
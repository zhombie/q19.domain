@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import kz.q19.utils.json.getStringOrNull
import kz.q19.utils.json.json
import org.json.JSONObject

@Parcelize
data class I18NString constructor(
    val value: @RawValue JSONObject
) : Parcelable {

    companion object {
        val NOT_FOUND: I18NString
            get() = I18NString(
                value = json {
                    put(Language.Key.EN.value, "Nothing found :(")
                    put(Language.Key.RU.value, "Ничего не найдено :(")
                    put(Language.Key.KK.value, "Ештеңе табылмады :(")
                }
            )
    }

    fun get(language: Language = Language.DEFAULT): String? {
        return value.getStringOrNull(language.key)
    }

}
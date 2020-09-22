@file:Suppress("unused")

package kz.q19.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Form constructor(
    val id: Long,
    val title: String? = null,
    val isFlex: Int = 0,
    val prompt: String? = null,
    val fields: List<Field> = emptyList()
) : Parcelable {

    @Parcelize
    data class Field constructor(
        val id: Long,
        val isFlex: Boolean = false,
        val title: String? = null,
        val prompt: String? = null,
        val type: Type,
        val default: String? = null,
        val formId: Long,
        val configs: Configs? = null,
        val level: Int = 0,
        val value: String? = null
    ) : Parcelable {

        enum class Type(val value: String) {
            TEXT("text"),
            AUDIO("audio"),
            IMAGE("image"),
            VIDEO("video"),
            FILE("file")
        }

        @Parcelize
        class Configs : Parcelable

    }

    fun isFlexibleForm(): Boolean {
        return isFlex == 1
    }

}
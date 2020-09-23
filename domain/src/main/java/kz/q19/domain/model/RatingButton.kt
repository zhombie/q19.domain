@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RatingButton constructor(
    val title: String?,
    val payload: String? = null
) : Parcelable {

    private val splitPayload: List<String>?
        get() = payload?.split(":")

    val rating: Int
        get() = splitPayload?.get(1)?.toInt() ?: -1

    val chatId: Long
        get() = splitPayload?.get(2)?.toLong() ?: -1

}
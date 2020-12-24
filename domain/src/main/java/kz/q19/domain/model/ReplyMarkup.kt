package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class ReplyMarkup constructor(
    val rows: List<List<Button>> = emptyList()
) : Parcelable {

    @Keep
    @Parcelize
    data class Button constructor(
        val text: String,
        val callbackData: String? = null,
        val url: String? = null
    ) : Parcelable

    fun getAllButtons(): List<Button> {
        val buttons = mutableListOf<Button>()
        rows.forEach {
            it.forEach { button ->
                buttons.add(button)
            }
        }
        return buttons
    }

    fun getColumnsCount(): Int {
        return if (!rows.isNullOrEmpty()) {
            rows.maxOf { it.size }
        } else {
            0
        }
    }

}
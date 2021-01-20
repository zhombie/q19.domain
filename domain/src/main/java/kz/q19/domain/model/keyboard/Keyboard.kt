package kz.q19.domain.model.keyboard

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.keyboard.button.Button

@Keep
@Parcelize
data class Keyboard constructor(
    val inline: Boolean = true,  // By default keyboard is inline
    val buttons: List<List<Button>>
) : Parcelable {

    constructor(
        inline: Boolean?,
        buttons: List<List<Button>>?
    ) : this(inline ?: true, buttons ?: emptyList())

    fun getAllButtons(): List<Button> {
        return buttons.flatten()
    }

    fun getColumnsCount(): Int {
        return if (!buttons.isNullOrEmpty()) {
            buttons.maxOf { it.size }
        } else {
            0
        }
    }

}
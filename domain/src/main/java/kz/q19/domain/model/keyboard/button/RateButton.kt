package kz.q19.domain.model.keyboard.button

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class RateButton constructor(
    override val text: String,
    val chatId: Long,
    val rating: Int
) : Button(text = text), Parcelable
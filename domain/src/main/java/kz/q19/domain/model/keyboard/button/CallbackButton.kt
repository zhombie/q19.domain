package kz.q19.domain.model.keyboard.button

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class CallbackButton constructor(
    override val text: String,
    val payload: String
) : Button(text = text), Parcelable
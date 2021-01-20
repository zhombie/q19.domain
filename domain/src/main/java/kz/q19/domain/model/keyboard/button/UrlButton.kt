package kz.q19.domain.model.keyboard.button

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class UrlButton constructor(
    override val text: String,
    val url: String
) : Button(text = text), Parcelable
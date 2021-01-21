package kz.q19.domain.model.keyboard.button

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class TextButton constructor(
    override val text: String
) : Button(text = text), Parcelable
package kz.q19.domain.model.keyboard.button

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
open class Button internal constructor(
    open val text: String
) : Parcelable
package kz.q19.domain.model.keyboard.button

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kz.garage.chat.model.reply_markup.button.TextButton

@Parcelize
data class RateButton constructor(
    override val id: String,
    override val text: String,
    val chatId: Long,
    val rating: Int
) : TextButton(text = text), Parcelable {

    constructor(
        text: String,
        chatId: Long,
        rating: Int
    ) : this(id = generateId(), text = text, chatId = chatId, rating = rating)

}
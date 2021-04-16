package kz.q19.domain.model.knowledge_base

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.media.Media2

@Parcelize
@Keep
data class ResponseInfo constructor(
    val id: String,
    val text: String,
    val time: Long,
    val attachments: List<Media2> = emptyList(),
    val form: Form? = null
) : BaseResponse(), Parcelable {

    @Parcelize
    @Keep
    data class Form constructor(
        val id: Long,
        val title: String,
        val prompt: String? = null
    ) : Parcelable

}
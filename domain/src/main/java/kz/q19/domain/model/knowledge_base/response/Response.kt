package kz.q19.domain.model.knowledge_base.response

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.garage.multimedia.store.model.Content
import kz.q19.domain.model.knowledge_base.response.base.BaseResponse

@Keep
@Parcelize
data class Response constructor(
    val id: Long,
    val messageId: String? = null,
    val text: String? = null,
    val time: Long = -1L,
    val attachments: List<Content> = emptyList(),
    val form: Form? = null
) : BaseResponse(), Parcelable {

    @Keep
    @Parcelize
    data class Form constructor(
        val id: Long,
        val title: String,
        val prompt: String? = null
    ) : Parcelable

}
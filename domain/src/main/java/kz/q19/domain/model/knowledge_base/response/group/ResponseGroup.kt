package kz.q19.domain.model.knowledge_base.response.group

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.knowledge_base.response.Response
import kz.q19.domain.model.knowledge_base.response.group.base.BaseGroupResponse
import kz.q19.domain.model.language.Language

@Keep
@Parcelize
data class ResponseGroup constructor(
    override val id: Long,
    override val title: String,
    override val language: Language,
    val isPrimary: Boolean = false,
    val children: List<BaseGroupResponse>
) : BaseGroupResponse(id = id, title = title, language = language), Parcelable {

    @Keep
    @Parcelize
    data class Child constructor(
        override val id: Long,
        override val title: String,
        override val language: Language,
        val responses: List<Response>
    ) : BaseGroupResponse(id = id, title = title, language = language), Parcelable

}

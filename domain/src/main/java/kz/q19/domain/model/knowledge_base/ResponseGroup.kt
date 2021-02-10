package kz.q19.domain.model.knowledge_base

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.language.Language

@Keep
@Parcelize
data class ResponseGroup constructor(
    val id: Long,
    val title: String,
    val language: Language,
    val children: MutableList<BaseResponse>,
    val extra: Extra
) : BaseResponse(), Parcelable {

    @Keep
    @Parcelize
    data class Extra constructor(
        val order: Int? = null
    ) : Parcelable

}
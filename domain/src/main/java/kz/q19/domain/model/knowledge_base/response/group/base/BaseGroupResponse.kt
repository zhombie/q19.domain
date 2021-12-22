package kz.q19.domain.model.knowledge_base.response.group.base

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.knowledge_base.response.base.BaseResponse
import kz.q19.domain.model.language.Language

@Keep
@Parcelize
open class BaseGroupResponse constructor(
    open val id: Long,
    open val title: String,
    open val language: Language
) : BaseResponse(), Parcelable
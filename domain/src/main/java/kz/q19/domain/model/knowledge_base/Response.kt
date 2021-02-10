package kz.q19.domain.model.knowledge_base

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.language.Language

@Keep
@Parcelize
data class Response constructor(
    val id: Long,
    val title: String,
    val language: Language,
    val responses: List<Long>  // Collection of response ids
) : BaseResponse(), Parcelable
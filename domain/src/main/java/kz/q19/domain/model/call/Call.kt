package kz.q19.domain.model.call

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.call.base.BaseCall

@Parcelize
open class Call private constructor(
    open val id: Long,
    open val title: String,
    open val topic: String? = null
) : BaseCall(), Parcelable {

    @Parcelize
    data class Text constructor(
        override val id: Long,
        override val title: String,
        override val topic: String? = null
    ) : Call(id, title, topic), Parcelable

    @Parcelize
    data class Audio constructor(
        override val id: Long,
        override val title: String,
        override val topic: String? = null
    ) : Call(id, title, topic), Parcelable

    @Parcelize
    data class Video constructor(
        override val id: Long,
        override val title: String,
        override val topic: String? = null
    ) : Call(id, title, topic), Parcelable

}
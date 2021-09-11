package kz.q19.domain.model.call

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

open class AnyCall

@Parcelize
open class Call private constructor(
    open val id: Long,
    open val title: String,
    open val topic: String? = null
) : AnyCall(), Parcelable {

    @Parcelize
    internal data class Text constructor(
        override val id: Long,
        override val title: String,
        override val topic: String? = null
    ) : Call(id, title, topic), Parcelable

    @Parcelize
    internal data class Audio constructor(
        override val id: Long,
        override val title: String,
        override val topic: String? = null
    ) : Call(id, title, topic), Parcelable

    @Parcelize
    internal data class Video constructor(
        override val id: Long,
        override val title: String,
        override val topic: String? = null
    ) : Call(id, title, topic), Parcelable

}

sealed class CallGroup private constructor(
    open val id: Long,
    open val title: String,
    open val children: List<AnyCall> = emptyList()
) : AnyCall() {

    data class Primary constructor(
        override val id: Long,
        override val title: String,
        override val children: List<AnyCall> = emptyList()
    ) : CallGroup(id, title, children)

    data class Secondary constructor(
        override val id: Long,
        override val title: String,
        override val children: List<AnyCall> = emptyList()
    ) : CallGroup(id, title, children)

}
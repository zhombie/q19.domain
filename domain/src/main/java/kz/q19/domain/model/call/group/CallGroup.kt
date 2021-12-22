package kz.q19.domain.model.call.group

import kz.q19.domain.model.call.base.BaseCall

sealed class CallGroup private constructor(
    open val id: Long,
    open val title: String,
    open val children: List<BaseCall> = emptyList()
) : BaseCall() {

    data class Primary constructor(
        override val id: Long,
        override val title: String,
        override val children: List<BaseCall> = emptyList()
    ) : CallGroup(id, title, children)

    data class Secondary constructor(
        override val id: Long,
        override val title: String,
        override val children: List<BaseCall> = emptyList()
    ) : CallGroup(id, title, children)

}
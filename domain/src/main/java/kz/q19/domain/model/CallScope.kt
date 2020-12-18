@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class CallScope constructor(
    @SerializedName("id")
    val id: Long,

    @SerializedName("type")
    val type: Type? = null,

    @SerializedName("scope")
    val scope: String? = null,

    @SerializedName("title")
    val title: I18NString,

    @SerializedName("parent_id")
    val parentId: Long = NO_PARENT_ID,

    @SerializedName("chat_type")
    val chatType: ChatType? = null,

    @SerializedName("action")
    val action: Action? = null,

    @SerializedName("details")
    val details: Details? = null
) : Parcelable {

    companion object {
        const val NO_PARENT_ID = 0L
    }

    @Keep
    enum class Type constructor(val value: String) {
        @SerializedName("folder")
        FOLDER("folder"),

        @SerializedName("link")
        LINK("link")
    }

    @Keep
    enum class Action constructor(val value: String) {
        @SerializedName("audio_call")
        AUDIO_CALL("audio_call"),

        @SerializedName("video_call")
        VIDEO_CALL("video_call")
    }

    @Keep
    enum class ChatType constructor(val value: String) {
        @SerializedName("audio")
        AUDIO("audio"),

        @SerializedName("video")
        VIDEO("video"),

        @SerializedName("external")
        EXTERNAL("external"),

        @SerializedName("form")
        FORM("form")
    }

    @Keep
    @Parcelize
    data class Details constructor(
        @SerializedName("order")
        val order: Int,

        @SerializedName("standard")
        val standard: Boolean? = null,

        @SerializedName("style")
        val style: String? = null,

        @SerializedName("subtitle")
        val subtitle: String? = null,

        @SerializedName("form_id")
        val formId: Long? = null,

        @SerializedName("external_id")
        val externalId: Long? = null
    ) : Parcelable

}
package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class CallScope(
    @SerializedName("id")
    val id: Long,

    @SerializedName("type")
    val type: Type? = null,

    @SerializedName("scope")
    val scope: String? = null,

    @SerializedName("title")
    val title: I18NString,

    @SerializedName("parent_id")
    val parentId: Long = -1L,

    @SerializedName("chat_type")
    val chatType: ChatType? = null,

    @SerializedName("action")
    val action: Action? = null,

    @SerializedName("details")
    val details: Details? = null
) : Parcelable {

    enum class Type(val value: String) {
        @SerializedName("folder")
        FOLDER("folder"),

        @SerializedName("link")
        LINK("link")
    }

    enum class Action(val value: String) {
        @SerializedName("audio_call")
        AUDIO_CALL("audio_call"),

        @SerializedName("video_call")
        VIDEO_CALL("video_call")
    }

    enum class ChatType(val value: String) {
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
    data class Details(
        @SerializedName("order")
        val order: Int,

        @SerializedName("standard")
        val standard: Boolean? = null,

        @SerializedName("style")
        val style: String? = null,

        @SerializedName("subtitle")
        val subtitle: String? = null
    ) : Parcelable

}
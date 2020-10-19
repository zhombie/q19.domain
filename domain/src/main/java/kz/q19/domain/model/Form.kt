@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Form constructor(
    @SerializedName("id")
    val id: Long,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("is_flex")
    val isFlex: Int = 0,

    @SerializedName("prompt")
    val prompt: String? = null,

    @SerializedName("fields")
    val fields: List<Field> = emptyList(),

    @SerializedName("configs")
    val configs: Configs? = null
) : Parcelable {

    @Keep
    @Parcelize
    data class Field constructor(
        @SerializedName("id")
        val id: Long,

        @SerializedName("is_flex")
        val isFlex: Boolean = false,

        @SerializedName("title")
        val title: String? = null,

        @SerializedName("prompt")
        val prompt: String? = null,

        @SerializedName("type")
        val type: Type,

        @SerializedName("default")
        val default: String? = null,

        @SerializedName("form_id")
        val formId: Long,

        @SerializedName("configs")
        val configs: Configs? = null,

        @SerializedName("level")
        val level: Int = 0,

        @SerializedName("value")
        val value: String? = null
    ) : Parcelable {

        enum class Type(val value: String) {
            @SerializedName("text")
            TEXT("text"),

            @SerializedName("audio")
            AUDIO("audio"),

            @SerializedName("image")
            IMAGE("image"),

            @SerializedName("video")
            VIDEO("video"),

            @SerializedName("file")
            FILE("file"),

            @SerializedName("select")
            SELECT("select"),

            @SerializedName("boolean")
            BOOLEAN("boolean")
        }

        @Parcelize
        data class Configs(
            @SerializedName("must_filled")
            val isRequiredField: Boolean? = null,

            @SerializedName("key")
            val key: String? = null,

            @SerializedName("regexp")
            val regexp: String? = null,

            @SerializedName("regexp_explanation")
            val regexpExplanation: String? = null
        ) : Parcelable

    }

    @Keep
    @Parcelize
    data class Configs(
        @SerializedName("assignee")
        val assignee: List<Long>? = null,

        @SerializedName("project_id")
        val projectId: Long? = null
    ) : Parcelable

    fun isFlexibleForm(): Boolean {
        return isFlex == 1
    }

}
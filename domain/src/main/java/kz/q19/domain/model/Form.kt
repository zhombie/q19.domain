@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kz.q19.utils.file.Extension

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
    val fields: List<Field>? = null,

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
        val type: Type? = null,

        @SerializedName("default")
        val default: String? = null,

        @SerializedName("form_id")
        val formId: Long,

        @SerializedName("info")
        val info: Info? = null,

        @SerializedName("configs")
        val configs: Configs? = null,

        @SerializedName("level")
        val level: Int = 0,

        @SerializedName("value")
        val value: String? = null,

        @SerializedName("keyboard")
        val keyboard: Keyboard? = null,

//        @SerializedName("condition")
//        val condition: Condition? = null,
    ) : Parcelable {

        @Keep
        enum class Type constructor(val value: String) {
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
            BOOLEAN("boolean"),

            @SerializedName("phone_number")
            PHONE_NUMBER("phone_number")
        }

        @Keep
        @Parcelize
        data class Configs constructor(
            @SerializedName("required")
            val isRequired: Boolean? = null,

            @SerializedName("multiple_selection")
            val isMultipleSelection: Boolean? = null,

            @SerializedName("max_selection_count")
            val maxSelectionCount: Int? = null,

            @SerializedName("key")
            val key: String? = null,

            @SerializedName("regexp")
            val regexp: String? = null,

            @SerializedName("regexp_explanation")
            val regexpExplanation: String? = null
        ) : Parcelable

        @Keep
        @Parcelize
        data class Info constructor(
            @SerializedName("extension")
            val extension: Extension? = null,

            @SerializedName("width")
            val width: Int? = null,

            @SerializedName("height")
            val height: Int? = null,

            @SerializedName("duration")
            val duration: Long? = null,  // milliseconds

            @SerializedName("date_added")
            val dateAdded: Long? = null,  // milliseconds

            @SerializedName("date_modified")
            val dateModified: Long? = null,  // milliseconds

            @SerializedName("date_taken")
            val dateTaken: Long? = null,  // milliseconds

            @SerializedName("size")
            val size: Long? = null
        ) : Parcelable


        @Keep
        @Parcelize
        data class Keyboard constructor(
            @SerializedName("inline")
            val inline: Boolean? = null,

            @SerializedName("buttons")
            val buttons: List<List<Button>>? = null
        ) : Parcelable {

            @Keep
            @Parcelize
            data class Button constructor(
                @SerializedName("text")
                val text: String,

                @SerializedName("payload")
                val payload: String? = null
            ) : Parcelable

        }

        @Keep
        @Parcelize
        data class Condition constructor(
            val map: HashMap<String, String>? = null,
        ) : Parcelable

    }

    @Keep
    @Parcelize
    data class Configs constructor(
        @SerializedName("assignee")
        val assignee: List<Long>? = null,

        @SerializedName("project_id")
        val projectId: Long? = null
    ) : Parcelable

    fun isFlexibleForm(): Boolean = isFlex == 1

}
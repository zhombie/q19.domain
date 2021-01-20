package kz.q19.domain.model.form

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.file.Extension
import kz.q19.domain.model.keyboard.Keyboard

@Keep
@Parcelize
data class Form constructor(
    val id: Long,
    val title: String,
    val prompt: String? = null,
    val isFlexible: Boolean = false,
    val fields: List<Field>,
    val configs: Configs? = null
) : Parcelable {

    @Keep
    @Parcelize
    data class Field constructor(
        val id: Long,
        val isFlexible: Boolean = false,
        val title: String,
        val prompt: String? = null,
        val type: Type,
        val defaultValue: String? = null,
        val info: Info? = null,
        val configs: Configs? = null,
        val level: Int = 0,
        val keyboard: Keyboard? = null,
        val isRequired: Boolean = false,
        val conditions: Conditions? = null,
        val autofill: Autofill? = null,
        val value: String? = null  // Value of the field
    ) : Parcelable {

        @Keep
        @Parcelize
        enum class Type constructor(val key: String) : Parcelable {
            TEXT("text"),
            IMAGE("image"),
            AUDIO("audio"),
            VIDEO("video"),
            FILE("file"),
            SELECT("select"),
            BOOLEAN("boolean"),
            PHONE_NUMBER("phone_number")
        }

        @Keep
        @Parcelize
        data class Configs constructor(
            val isMultipleSelection: Boolean = false,
            val maxSelectionCount: Int = 0,
            val key: String? = null,
            val regexp: String? = null,
            val regexpExplanation: String? = null
        ) : Parcelable

        @Keep
        @Parcelize
        data class Info constructor(
            val extension: Extension? = null,
            val width: Int? = null,
            val height: Int? = null,
            val duration: Long? = null,  // milliseconds
            val dateAdded: Long? = null,  // milliseconds
            val dateModified: Long? = null,  // milliseconds
            val dateTaken: Long? = null,  // milliseconds
            val size: Long? = null
        ) : Parcelable

        @Keep
        @Parcelize
        data class Conditions constructor(
            val keyboard: List<Condition>? = null,
        ) : Parcelable {

            @Keep
            @Parcelize
            data class Condition constructor(
                val payload: String? = null,
                val nextStep: Int? = null,
                val showSteps: List<Int>? = null,
                val hideSteps: List<Int>? = null
            ) : Parcelable

        }

        @Keep
        @Parcelize
        data class Autofill constructor(
            val qualifier: Qualifier? = null
        ) : Parcelable {

            @Keep
            @Parcelize
            enum class Qualifier : Parcelable {
                UNKNOWN,
                USER_FIRST_NAME,
                USER_LAST_NAME,
                USER_FULL_NAME,
                USER_IIN,
                USER_EMAIL,
                USER_PHONE_NUMBER
            }

        }

    }

    @Keep
    @Parcelize
    data class Configs constructor(
        val assignees: List<Long>? = null,
        val projectId: Long = NO_PROJECT_ID
    ) : Parcelable {

        companion object {
            const val NO_PROJECT_ID = -1L
        }

    }

}
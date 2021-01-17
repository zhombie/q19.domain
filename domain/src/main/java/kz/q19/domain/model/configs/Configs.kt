package kz.q19.domain.model.configs

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.i18n.I18NString

@Keep
@Parcelize
data class Configs constructor(
    val bot: Bot,
    val callAgent: CallAgent,
    val preferences: Preferences,

    val calls: List<Call>? = null,
    val services: List<Service>? = null,
    val forms: List<Form>? = null,
) : Parcelable {

    @Keep
    @Parcelize
    data class Bot constructor(
        val image: String? = null,
        val title: String? = null
    ) : Parcelable

    @Keep
    @Parcelize
    data class CallAgent constructor(
        val defaultName: String? = null
    ) : Parcelable

    @Keep
    @Parcelize
    data class Preferences constructor(
        val isChatBotEnabled: Boolean = false,

        val isPhonesListShown: Boolean = false,
        val isContactSectionsShown: Boolean = false,

        val isAudioCallEnabled: Boolean = false,
        val isVideoCallEnabled: Boolean = false,

        val isServicesEnabled: Boolean = false,

        val isCallAgentsScoped: Boolean = false
    ) : Parcelable

    @Keep
    @Parcelize
    open class Nestable constructor(
        open val id: Long,
        open val parentId: Long,
        open val type: Type?,
        open val extra: Extra? = null
    ) : Parcelable

    @Keep
    @Parcelize
    data class Call constructor(
        override val id: Long,
        override val parentId: Long,
        override val type: Type?,
        val callType: CallType? = null,
        val title: I18NString,
        val scope: String? = null,
        override val extra: Extra? = null
    ) : Nestable(id = id, parentId = parentId, type = type, extra = extra), Parcelable {

        @Keep
        enum class CallType {
            AUDIO,
            VIDEO
        }

    }

    @Keep
    @Parcelize
    data class Service constructor(
        override val id: Long,
        override val parentId: Long,
        override val type: Type?,
        val serviceId: Long,
        val title: I18NString,
        override val extra: Extra? = null
    ) : Nestable(id = id, parentId = parentId, type = type, extra = extra), Parcelable

    @Keep
    @Parcelize
    data class Form constructor(
        override val id: Long,
        override val parentId: Long,
        override val type: Type?,
        val formId: Long,
        val title: I18NString,
        override val extra: Extra? = null
    ) : Nestable(id = id, parentId = parentId, type = type, extra = extra),  Parcelable

    @Keep
    enum class Type {
        LINK,
        FOLDER
    }

    @Keep
    @Parcelize
    data class Extra constructor(
        val order: Int? = null
    ) : Parcelable

}
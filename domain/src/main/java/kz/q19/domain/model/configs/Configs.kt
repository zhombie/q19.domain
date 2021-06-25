package kz.q19.domain.model.configs

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.call.CallType
import kz.q19.domain.model.i18n.I18NId
import kz.q19.domain.model.i18n.I18NString

@Keep
@Parcelize
data class Configs constructor(
    val bot: Bot,
    val callAgent: CallAgent,
    val preferences: Preferences,

    val contacts: Contacts? = null,

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
    open class Nestable internal constructor(
        open val id: Long,
        open val parentId: Long,
        open val type: Type?,
        open val title: I18NString,
        open val extra: Extra? = null
    ) : Parcelable {

        companion object {
            const val NO_PARENT_ID: Long = 0L
        }

        @Keep
        @Parcelize
        data class Extra constructor(
            val order: Int? = null,
            val behavior: Behavior? = null
        ) : Parcelable {

            @Keep
            @Parcelize
            enum class Behavior : Parcelable {
                UNKNOWN,
                REGULAR,
                REQUEST_LOCATION
            }

        }

        @Keep
        @Parcelize
        enum class Type : Parcelable {
            LINK,
            FOLDER
        }

        fun isParent(): Boolean = parentId == NO_PARENT_ID

        fun isFolder(): Boolean = type == Type.FOLDER

        fun isLink(): Boolean = type == Type.LINK

    }

    @Keep
    @Parcelize
    data class Call constructor(
        override val id: Long,
        override val parentId: Long,
        override val type: Type?,
        val callType: CallType? = null,
        val scope: String? = null,
        override val title: I18NString,
        override val extra: Extra? = null
    ) : Nestable(id = id, parentId = parentId, type = type, title = title, extra = extra), Parcelable {

        fun isAudioCall(): Boolean = callType == CallType.AUDIO

        fun isVideoCall(): Boolean = callType == CallType.VIDEO

        fun isMediaCall(): Boolean = isAudioCall() || isVideoCall()

    }

    @Keep
    @Parcelize
    data class Service constructor(
        override val id: Long,
        override val parentId: Long,
        override val type: Type?,
        val serviceId: Long,
        override val title: I18NString,
        override val extra: Extra? = null
    ) : Nestable(id = id, parentId = parentId, type = type, title = title, extra = extra), Parcelable

    @Keep
    @Parcelize
    data class Form constructor(
        override val id: Long,
        override val parentId: Long,
        override val type: Type?,
        val formId: I18NId,
        override val title: I18NString,
        override val extra: Extra? = null
    ) : Nestable(id = id, parentId = parentId, type = type, title = title, extra = extra), Parcelable

    @Keep
    @Parcelize
    data class Contacts constructor(
        val phoneNumbers: List<PhoneNumber>? = null,
        val socials: List<Social>? = null
    ) : Parcelable {

        @Keep
        @Parcelize
        data class Social constructor(val id: Id, val url: String) : Parcelable {

            @Keep
            @Parcelize
            enum class Id(val id: String) : Parcelable {
                FACEBOOK("fb"),
                TELEGRAM("tg"),
                TWITTER("tw"),
                VK("vk"),
                WHATSAPP("whatsapp")
            }

        }

        @Keep
        @Parcelize
        data class PhoneNumber constructor(
            val value: String,
            val info: I18NString? = null,
            val action: String? = null
        ) : Parcelable

    }

}
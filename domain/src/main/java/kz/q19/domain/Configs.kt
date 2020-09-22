@file:Suppress("unused")

package kz.q19.domain

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Configs constructor(
    val booleans: Booleans? = null,
    val opponent: Opponent? = null,
    val contacts: List<Contact>? = null,
    val phones: List<String>? = null,
    val infoBlocks: List<InfoBlock>? = null,
    val callScopes: List<CallScope>? = null
) : Parcelable {

    @Parcelize
    data class Opponent constructor(
        val name: String? = null,
        val secondName: String? = null,
        val avatarUrl: String? = null,

        @DrawableRes
        val drawableRes: Int = UNDEFINED_DRAWABLE_RES
    ) : Parcelable {

        companion object {
            private const val UNDEFINED_DRAWABLE_RES = -1

            val DEFAULT: Opponent
                get() {
                    return Opponent(
                        secondName = "Smart Bot",
                        drawableRes = R.drawable.ic_robot
                    )
                }
        }

        val isDrawableResAvailable: Boolean
            get() = drawableRes != UNDEFINED_DRAWABLE_RES

    }

    @Parcelize
    data class Contact constructor(
        val key: String,
        val value: String
    ) : Parcelable {

        enum class Social(
            val key: String,
            val title: String,
            @DrawableRes val icon: Int
        ) {
            FACEBOOK("fb", "Facebook", R.drawable.ic_facebook_messenger),
            TELEGRAM("tg", "Telegram", R.drawable.ic_telegram),
            TWITTER("tw", "Twitter", R.drawable.ic_twitter),
            VK("vk", "ВКонтакте", R.drawable.ic_vk)
        }

        val social: Social?
            get() = when (key) {
                Social.FACEBOOK.key -> Social.FACEBOOK
                Social.TELEGRAM.key -> Social.TELEGRAM
                Social.TWITTER.key -> Social.TWITTER
                Social.VK.key -> Social.VK
                else -> null
            }

        val url: String
            get() {
                var url = value
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://$url"
                }
                return url
            }

    }

    @Parcelize
    data class InfoBlock constructor(
        val title: I18NString,
        val description: I18NString,
        val items: List<Item>
    ) : Parcelable {

        @Parcelize
        data class Item constructor(
            val icon: String? = null,
            val text: String,
            val description: I18NString,
            val action: String
        ) : Parcelable

    }

    @Parcelize
    data class Booleans constructor(
        val isChatBotEnabled: Boolean? = false,
        val isAudioCallEnabled: Boolean? = false,
        val isVideoCallEnabled: Boolean? = false,
        val isContactSectionsShown: Boolean? = false,
        val isPhonesListShown: Boolean? = false,
        val isOperatorsScoped: Boolean? = false,
        val isServicesEnabled: Boolean? = false
    ) : Parcelable

    @Parcelize
    data class CallScope constructor(
        val id: Long,
        val type: Type? = null,
        val scope: String? = null,
        val title: I18NString,
        val parentId: Long = -1L,
        val chatType: ChatType? = null,
        val action: Action? = null,
        val details: Details? = null
    ) : Parcelable {

        companion object {
            private const val NO_PARENT_ID = 0L

            fun isAllParentCallScopes(callScopes: List<CallScope>?): Boolean {
                if (callScopes.isNullOrEmpty()) return false
                return callScopes.all { it.parentId == NO_PARENT_ID }
            }

            fun getCallScopes(callScopes: List<CallScope>?, id: Long?): List<CallScope>? {
                if (callScopes.isNullOrEmpty()) return null
                return callScopes.filter { it.parentId == id }
            }

            fun getMediaCallScopes(
                callScopes: List<CallScope>?,
                id: Long = NO_PARENT_ID
            ): List<CallScope>? {
                return getCallScopes(
                    callScopes = callScopes?.filter {
                        it.chatType == ChatType.AUDIO || it.chatType == ChatType.VIDEO
                    },
                    id = id
                )
            }

            fun getExternalServices(
                callScopes: List<CallScope>?,
                id: Long = NO_PARENT_ID
            ): List<Service>? {
                return getCallScopes(
                    callScopes = callScopes?.filter {
                        it.chatType == ChatType.EXTERNAL || it.chatType == ChatType.FORM
                    },
                    id = id
                )?.map {
                    Service(
                        id = it.id,
                        type = it.type,
                        scope = it.scope,
                        title = it.title,
                        parentId = it.parentId,
                        chatType = it.chatType,
                        action = it.action,
                        details = it.details
                    )
                }
            }

            val EMPTY: CallScope
                get() {
                    return CallScope(
                        id = -1L,
                        type = null,
                        scope = null,
                        title = I18NString.NOT_FOUND,
                        parentId = -1L,
                        chatType = null,
                        action = null
                    )
                }

        }

        enum class Type(val value: String) {
            FOLDER("folder"),
            LINK("link")
        }

        enum class Action(val value: String) {
            AUDIO_CALL("audio_call"),
            VIDEO_CALL("video_call")
        }

        enum class ChatType(val value: String) {
            AUDIO("audio"),
            VIDEO("video"),
            EXTERNAL("external"),
            FORM("form")
        }

        @Parcelize
        data class Details constructor(
            val order: Int,
            val standard: Boolean,
            val style: String?,
            val subtitle: String?
        ) : Parcelable

    }

}
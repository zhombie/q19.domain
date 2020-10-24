package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Booleans constructor(
    @SerializedName("chatbot_enabled")
    val isChatBotEnabled: Boolean = false,

    @SerializedName("phones_list_shown")
    val isPhonesListShown: Boolean = false,

    @SerializedName("contact_sections_shown")
    val isContactSectionsShown: Boolean = false,

    @SerializedName("video_call_enabled")
    val isVideoCallEnabled: Boolean = false,

    @SerializedName("audio_call_enabled")
    val isAudioCallEnabled: Boolean = false,

    @SerializedName("services_enabled")
    val isServicesEnabled: Boolean = false,

    @SerializedName("operators_scoped")
    val isOperatorsScoped: Boolean = false
) : Parcelable
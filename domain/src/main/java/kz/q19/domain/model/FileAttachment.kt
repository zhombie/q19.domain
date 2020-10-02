@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize
import java.io.File

@Keep
@Parcelize
data class FileAttachment constructor(
    val attachment: Attachment,
    val file: File
) : Parcelable
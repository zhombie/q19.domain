@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.File

@Parcelize
data class FileAttachment constructor(
    val attachment: Attachment,
    val file: File
) : Parcelable
package kz.q19.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.File

@Parcelize
data class FileAttachment(
    val attachment: Attachment,
    val file: File
) : Parcelable
@file:Suppress("unused")

package kz.q19.domain.model

import android.net.Uri
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import kz.q19.utils.enums.findEnumBy
import kz.q19.utils.file.Extension
import java.io.File

@Keep
@Parcelize
data class File constructor(
    private val file: File
) : Parcelable {

    enum class DownloadStatus {
        NONE,
        PENDING,
        ERROR,
        COMPLETED
    }

    val name: String
        get() = file.name

    val nameWithoutExtension: String
        get() = file.nameWithoutExtension

    val extension: Extension?
        get() = findEnumBy { it.value == file.extension }

    val path: String
        get() = file.path

    val absolutePath: String
        get() = file.absolutePath

    val uri: Uri
        get() = Uri.fromFile(file)

    @IgnoredOnParcel
    var progress: Int = 0
        set(value) {
            field = value
            if (value == 100) {
                downloadStatus = DownloadStatus.COMPLETED
            } else if (value in 1..99) {
                downloadStatus = DownloadStatus.PENDING
            }
        }

    @IgnoredOnParcel
    var downloadStatus: DownloadStatus = DownloadStatus.NONE
        set(value) {
            if (value == DownloadStatus.NONE) {
                field = value
                return
            } else if (field == DownloadStatus.COMPLETED) {
                return
            }
            if (field == value) return
            field = value
        }

}
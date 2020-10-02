@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
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

    val path: String
        get() = file.absolutePath

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
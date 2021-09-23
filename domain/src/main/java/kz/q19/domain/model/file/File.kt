package kz.q19.domain.model.file

import android.net.Uri
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kz.q19.domain.utils.findEnumBy
import java.io.File

@Keep
@Parcelize
data class File constructor(
    private val file: File
) : Parcelable {

    @Keep
    enum class DownloadStatus {
        NONE,
        PENDING,
        ERROR,
        COMPLETED
    }

    fun get(): File {
        return file
    }

    val name: String
        get() = file.name

    val nameWithoutExtension: String
        get() = file.nameWithoutExtension

    val extension: Extension?
        get() = findEnumBy { it.value == file.extension.lowercase() }

    val path: String
        get() = file.path

    val absolutePath: String
        get() = file.absolutePath

    val uri: Uri
        get() = Uri.fromFile(file)

    val exists: Boolean
        get() = file.exists()

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
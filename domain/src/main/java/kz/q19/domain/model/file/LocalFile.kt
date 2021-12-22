package kz.q19.domain.model.file

import android.net.Uri
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import java.io.File

@JvmInline
@Keep
@Parcelize
value class LocalFile constructor(
    private val file: File
) : Parcelable {

    fun get(): File = file

    val name: String
        get() = file.name

    val nameWithoutExtension: String
        get() = file.nameWithoutExtension

    val path: String
        get() = file.path

    val absolutePath: String
        get() = file.absolutePath

    val uri: Uri
        get() = Uri.fromFile(file)

    fun isExist(): Boolean = file.exists()

    fun delete(): Boolean = file.delete()

}
package kz.q19.domain.model.media

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.file.LocalFile

@Keep
@Parcelize
data class Audio constructor(
    override val id: String,

    override val title: String?,
    override val displayName: String?,

    override val folder: Folder?,

    override val properties: Properties?,
    override val dates: Dates?,

    override val local: Local?,
    override val remote: Remote?,

    override val duration: Long?
) : Media2(
    id = id,
    title = title,
    displayName = displayName,
    folder = folder,
    properties = properties,
    dates = dates,
    remote = remote,
), Playable, Parcelable {

    @Keep
    @Parcelize
    data class Local constructor(
        override val localFile: LocalFile?,
        val thumbnail: Thumbnail?
    ) : Media2.Local(localFile = localFile), Parcelable {

        override fun isEmpty(): Boolean =
            localFile == null && (thumbnail == null || thumbnail.isEmpty())

    }

}
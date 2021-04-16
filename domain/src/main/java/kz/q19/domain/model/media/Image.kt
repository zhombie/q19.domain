package kz.q19.domain.model.media

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.q19.domain.model.file.LocalFile

@Keep
@Parcelize
data class Image constructor(
    override val id: String,

    override val title: String?,
    override val displayName: String?,

    override val folder: Folder?,

    override val properties: Properties?,
    override val dates: Dates?,

    override val local: Local?,
    override val remote: Remote?
) : Media2(
    id = id,
    title = title,
    displayName = displayName,
    folder = folder,
    properties = properties,
    dates = dates,
    local = local,
    remote = remote
), Parcelable {

    @Keep
    @Parcelize
    data class Local constructor(
        override val localFile: LocalFile?,
        val bitmaps: Bitmaps?
    ) : Media2.Local(localFile = localFile), Parcelable {

        @Keep
        @Parcelize
        data class Bitmaps constructor(
            val source: Source?,
            val thumbnail: Thumbnail?,
        ) : Empty, Parcelable {

            override fun isEmpty(): Boolean =
                (source == null || source.isEmpty()) && (thumbnail == null || thumbnail.isEmpty())

        }

        @Keep
        @Parcelize
        data class Source constructor(
            val bitmap: Bitmap?,
            val displaySize: DisplaySize?,
        ) : Empty, Parcelable {

            override fun isEmpty(): Boolean =
                bitmap == null && (displaySize == null || displaySize.isEmpty())

        }

        override fun isEmpty(): Boolean =
            localFile == null && (bitmaps == null || bitmaps.isEmpty())

    }

    @Keep
    @Parcelize
    data class Remote constructor(
        override val urlPath: String?,
        val displaySize: DisplaySize?
    ) : Media2.Remote(urlPath = urlPath), Parcelable {

        override fun isEmpty(): Boolean =
            urlPath.isNullOrEmpty() && (displaySize == null || displaySize.isEmpty())

    }

}
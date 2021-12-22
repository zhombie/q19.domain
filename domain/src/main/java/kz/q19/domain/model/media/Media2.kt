package kz.q19.domain.model.media

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kz.garage.file.extension.Extension
import kz.q19.domain.model.file.LocalFile

@Keep
@Parcelize
open class Media2 constructor(
    open val id: String,

    open val title: String? = null,
    open val displayName: String? = null,

    open val folder: Folder? = null,

    open val properties: Properties? = null,
    open val dates: Dates? = null,

    open val local: Local? = null,
    open val remote: Remote? = null
) : Parcelable {

    @Keep
    @Parcelize
    data class Properties constructor(
        val extension: Extension? = null,
        val fileSize: Long? = null
    ) : Empty, Parcelable {

        override fun isEmpty(): Boolean =
            extension == null && fileSize == null

    }

    @Keep
    @Parcelize
    data class Thumbnail constructor(
        val bitmap: Bitmap? = null,
        val displaySize: DisplaySize? = null,
    ) : Empty, Parcelable {

        override fun isEmpty(): Boolean =
            bitmap == null && (displaySize == null || displaySize.isEmpty())

    }

    @Keep
    @Parcelize
    data class DisplaySize constructor(
        val width: Int? = null,
        val height: Int? = null
    ) : Empty, Parcelable {

        override fun isEmpty(): Boolean = width == null && height == null

    }

    @Keep
    @Parcelize
    data class Dates constructor(
        val added: Long? = null,  // milliseconds
        val modified: Long? = null,  // milliseconds
        val created: Long? = null,  // milliseconds
    ) : Empty, Parcelable {

        override fun isEmpty(): Boolean =
            added == null && modified == null && created == null

    }

    @Keep
    @Parcelize
    open class Local constructor(
        open val localFile: LocalFile? = null
    ) : Empty, Parcelable {

        override fun isEmpty(): Boolean =
            localFile == null

    }

    @Keep
    @Parcelize
    open class Remote constructor(
        // Shortened server url path without domain/hostname
        open val urlPath: String? = null
    ) : Empty, Parcelable {

        override fun isEmpty(): Boolean =
            urlPath.isNullOrEmpty()

    }

    @Keep
    @Parcelize
    data class Folder constructor(
        val id: String? = null,
        val displayName: String? = null
    ) : Empty, Parcelable {

        override fun isEmpty(): Boolean =
            id.isNullOrBlank() && displayName.isNullOrBlank()

    }

}
@file:Suppress("unused")

package kz.q19.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Category constructor(
    val id: Long,
    val title: String? = null,
    val language: Language.ID = Language.ID.RU,
    val parentId: Long = NO_PARENT_ID,
    val photo: String? = null,
    val children: List<Category> = emptyList(),
    val responses: List<Long> = emptyList(),
    val config: Config? = null
) : Parcelable {

    companion object {
        const val NO_ID: Long = -1L
        const val NO_PARENT_ID: Long = 0L

        val EMPTY: Category
            get() {
                return Category(
                    id = NO_ID,
                    title = I18NString.NOT_FOUND.get(Language.DEFAULT),
                    language = Language.ID.by(Language.DEFAULT.id),
                    parentId = NO_PARENT_ID,
                    photo = null,
                    children = emptyList(),
                    responses = emptyList(),
                    config = null
                )
            }
    }

    @Keep
    @Parcelize
    data class Config(
        val order: Int
    ) : Parcelable

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is Category) return false
        if (id == other.id && parentId == other.parentId) return true
        return false
    }
    override fun hashCode(): Int {
        return super.hashCode()
    }

}
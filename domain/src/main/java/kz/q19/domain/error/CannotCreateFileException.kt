@file:Suppress("unused")

package kz.q19.domain.error

import kz.q19.domain.R

class CannotCreateFileException : BaseException() {
    override val text: Int
        get() = R.string.error_cannot_create_file
}
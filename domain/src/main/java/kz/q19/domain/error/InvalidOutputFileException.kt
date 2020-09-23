@file:Suppress("unused")

package kz.q19.domain.error

import kz.q19.domain.R

class InvalidOutputFileException : BaseException() {
    override val text: Int
        get() = R.string.error_invalid_output_file
}
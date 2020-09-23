@file:Suppress("unused")

package kz.q19.domain.error

import kz.q19.domain.R

class NoSpaceAvailableException : BaseException() {
    override val text: Int
        get() = R.string.error_no_available_space
}
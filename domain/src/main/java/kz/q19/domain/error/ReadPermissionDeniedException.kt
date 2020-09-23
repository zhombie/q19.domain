@file:Suppress("unused")

package kz.q19.domain.error

import kz.q19.domain.R

class ReadPermissionDeniedException : BaseException() {
    override val text: Int
        get() = R.string.error_read_permission_denied
}
package kz.q19.domain.error

import androidx.annotation.StringRes

abstract class BaseException : Exception() {
    abstract val text: Int
        @StringRes get
}
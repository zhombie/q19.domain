package kz.q19.domain.utils

internal inline fun <reified T : Enum<*>> findEnumBy(predicate: (T) -> Boolean): T? =
    T::class.java.enumConstants?.find(predicate)
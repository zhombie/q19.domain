package kz.q19.domain.model.form

import kz.q19.domain.model.media.Media

fun Media.convert(): Form.Field.Type {
    return when (type) {
        Media.Type.IMAGE -> Form.Field.Type.IMAGE
        Media.Type.AUDIO -> Form.Field.Type.AUDIO
        Media.Type.VIDEO -> Form.Field.Type.VIDEO
        Media.Type.FILE -> Form.Field.Type.FILE
        else -> Form.Field.Type.FILE
    }
}
package kz.q19.domain.model

fun FileAttachment.convert(): Form.Field.Type {
    return when (type) {
        Attachment.Type.IMAGE -> Form.Field.Type.IMAGE
        Attachment.Type.AUDIO -> Form.Field.Type.AUDIO
        Attachment.Type.VIDEO -> Form.Field.Type.VIDEO
        Attachment.Type.FILE -> Form.Field.Type.FILE
        else -> Form.Field.Type.FILE
    }
}
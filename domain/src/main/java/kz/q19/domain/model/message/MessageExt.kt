package kz.q19.domain.model.message

import kz.q19.domain.model.media.Media

fun Message.hasOnlyTextMessage(): Boolean {
    return !text.isNullOrBlank() &&
        keyboard == null &&
        (media == null || media.urlPath.isNullOrBlank()) &&
        attachments.isNullOrEmpty() &&
        location == null
}

fun Message.hasOnlyImageMessage(): Boolean {
    return hasOnlyMediaOrAttachments(Media.Type.IMAGE)
}

fun Message.hasOnlyImageAlbumMessage(): Boolean {
    return hasOnlyAttachments(Media.Type.IMAGE, 2)
}

fun Message.hasOnlyVideoMessage(): Boolean {
    return hasOnlyMediaOrAttachments(Media.Type.VIDEO)
}

fun Message.hasOnlyAudioMessage(): Boolean {
    return hasOnlyMediaOrAttachments(Media.Type.AUDIO)
}


fun Media.hasRemoteUrl(): Boolean {
    return !urlPath.isNullOrBlank()
}

fun Message.hasMedia(type: Media.Type): Boolean {
    val media = media ?: return false
    return media.type == type && media.hasRemoteUrlOrLocalFile()
}

fun Message.hasAttachments(type: Media.Type, atLeast: Int = -1): Boolean {
    val attachments = attachments
    if (attachments.isNullOrEmpty()) return false
    if (attachments.all { it.type == type && it.hasRemoteUrlOrLocalFile() }) {
        if (atLeast == -1) {
            return true
        } else {
            if (attachments.size >= atLeast) {
                return true
            }
        }
    }
    return false
}

fun Message.hasOnlyMediaOrAttachments(type: Media.Type): Boolean {
    if (keyboard == null && location == null) {
        if (hasMedia(type)) return true
        if (hasAttachments(type)) return true
    }
    return false
}

fun Message.hasOnlyAttachments(type: Media.Type, atLeast: Int = -1): Boolean {
    if (keyboard == null && location == null) {
        if (hasAttachments(type, atLeast)) return true
    }
    return false
}

fun Media.hasRemoteUrlOrLocalFile(): Boolean {
    return hasRemoteUrl() || hasLocalFile()
}


fun Message.hasOnlyImageAndTextMessage(): Boolean {
    return hasOnlyMediaAndText(Media.Type.IMAGE)
}

fun Message.hasOnlyVideoAndTextMessage(): Boolean {
    return hasOnlyMediaAndText(Media.Type.VIDEO)
}

fun Message.hasOnlyAudioAndTextMessage(): Boolean {
    return hasOnlyMediaAndText(Media.Type.AUDIO)
}

fun Message.isEmpty(): Boolean {
    return title.isNullOrBlank() &&
        text.isNullOrBlank() &&
        keyboard == null &&
        (media == null || media.urlPath.isNullOrBlank()) &&
        attachments.isNullOrEmpty() &&
        location == null
}

fun Message.hasUrlPath(type: Media.Type): Boolean {
    return media != null && !media.urlPath.isNullOrBlank() && media.type == type
}

fun Message.hasLocalFile(type: Media.Type): Boolean {
    return media != null && media.file?.exists == true && media.type == type
}

fun Message.hasOnlyMediaAndText(type: Media.Type): Boolean {
    return keyboard == null &&
        (hasUrlPath(type) || hasLocalFile(type)) &&
        attachments.isNullOrEmpty() &&
        location == null
}
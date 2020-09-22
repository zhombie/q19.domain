@file:Suppress("unused")

package kz.q19.domain

enum class Extension(val value: String) {
    JPG("jpg"),
    JPEG("jpeg"),
    PNG("png"),

    TXT("txt"),

    DOC("doc"),
    DOCX("docx"),

    XLS("xls"),
    XLSX("xlsx"),

    PDF("pdf"),

    HTML("html"),

    MP3("mp3"),
    WAV("wav"),
    OPUS("opus"),
    OGG("ogg"),

    MP4("mp4"),
    MOV("mov"),
    WEBM("webm"),
    MKV("mkv"),
    AVI("avi")
}
package ru.skillbranch.devintensive.extensions

fun String.stripHtml(): String {
    return this.replace(Regex("[&<.*>'\"/]"), "")
}

fun String.truncate(): String {
    return ""
}
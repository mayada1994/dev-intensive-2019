package ru.skillbranch.devintensive.extensions

fun String.stripHtml(): String {
    val htmlRegex = Regex("(<.*?>)|(&[^ а-я]{1,4}?;)")
    val spaceRegex = Regex(" {2,}")
    return this.replace(htmlRegex, "").replace(spaceRegex, " ")
}

fun String.truncate(symbolsAmount: Int = 16): String {
    val resultingString = this.trim()
    return if (resultingString.length <= symbolsAmount) resultingString else resultingString.substring(
        0,
        symbolsAmount
    ).trim() + "..."
}
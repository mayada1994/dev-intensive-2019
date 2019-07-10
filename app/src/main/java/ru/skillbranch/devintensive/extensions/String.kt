package ru.skillbranch.devintensive.extensions

fun String.stripHtml(): String {
    val htmlRegex = Regex("(<.*?>)|(&[^ а-я]{1,4}?;)")
    val spaceRegex = Regex(" {2,}")
    return this.replace(htmlRegex, "").replace(spaceRegex, " ")
}

fun String.truncate(symbolsAmount: Int = 16): String {

    val originalString: String = this
    val resultingString: String = this.substring(0, symbolsAmount)
    return if (resultingString.length <= originalString.length) {
        originalString
    } else {
        if (resultingString.endsWith(" ")) {
            resultingString.substring(0, resultingString.length - 1).plus("...")
        } else {
            resultingString.plus("...")
        }
    }
}
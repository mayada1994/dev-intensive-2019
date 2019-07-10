package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val pairs = fullName?.split(" ")
        if (fullName?.trim() == "")
            return null to null
        return (pairs?.getOrNull(0) ?: "null") to (pairs?.getOrNull(1) ?: "null")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        if (firstName?.trim() == "" && lastName?.trim() == "" ||
            firstName.equals(null) && lastName.equals(null)
        )
            return null
        val a = firstName?.getOrNull(0) ?: ""
        val b = lastName?.getOrNull(0) ?: ""

        return "$a$b".toUpperCase()
    }

    fun transliteration(fullName: String?, divider: String? = ""): String? {

        var currentDivider: String = " "
        if (!divider.isNullOrEmpty()) {
            currentDivider = divider
        }
        val name: Pair<String?, String?> = parseFullName(fullName)
        var transFirstName: String? = name.first
        if (transFirstName != null) {
            transFirstName = ""
            name.first?.asIterable()?.forEach { letter ->
                transFirstName = transFirstName.plus(replaceLetter(letter.toString(), letter.isUpperCase()))
            }
        }

        var transLastName: String? = name.second
        if (transLastName != null) {
            transLastName = ""
            name.second?.asIterable()?.forEach { letter ->
                transLastName = transLastName.plus(replaceLetter(letter.toString(), letter.isUpperCase()))
            }
        }

        return "$transFirstName$currentDivider$transLastName"
    }

    fun replaceLetter(letter: String, isUpperCase: Boolean): String {
        var currentLetter: String = letter
        if (isUpperCase) {
            currentLetter = letter.toLowerCase()
        }
        return when (currentLetter) {
            "а" -> handleLetterCase("a", isUpperCase)

            "б" -> handleLetterCase("b", isUpperCase)

            "в" -> handleLetterCase("v", isUpperCase)

            "г" -> handleLetterCase("g", isUpperCase)

            "д" -> handleLetterCase("d", isUpperCase)

            "е" -> handleLetterCase("e", isUpperCase)

            "ё" -> handleLetterCase("e", isUpperCase)

            "ж" -> { if (isUpperCase) { "Zh" } else { "zh" } }

            "з" -> handleLetterCase("z", isUpperCase)

            "и" -> handleLetterCase("i", isUpperCase)

            "й" -> handleLetterCase("i", isUpperCase)

            "к" -> handleLetterCase("k", isUpperCase)

            "л" -> handleLetterCase("l", isUpperCase)

            "м" -> handleLetterCase("m", isUpperCase)

            "н" -> handleLetterCase("n", isUpperCase)

            "о" -> handleLetterCase("o", isUpperCase)

            "п" -> handleLetterCase("p", isUpperCase)

            "р" -> handleLetterCase("r", isUpperCase)

            "с" -> handleLetterCase("s", isUpperCase)

            "т" -> handleLetterCase("t", isUpperCase)

            "у" -> handleLetterCase("u", isUpperCase)

            "ф" -> handleLetterCase("f", isUpperCase)

            "х" -> handleLetterCase("h", isUpperCase)

            "ц" -> handleLetterCase("c", isUpperCase)

            "ч" -> { if (isUpperCase) { "Ch" } else { "ch" } }

            "ш" -> { if (isUpperCase) { "Sh" } else { "sh" } }

            "щ" -> { if (isUpperCase) { "Sh'" } else { "sh'" } }

            "ъ" -> handleLetterCase("", isUpperCase)

            "ы" -> handleLetterCase("i", isUpperCase)

            "ь" -> handleLetterCase("", isUpperCase)

            "э" -> handleLetterCase("e", isUpperCase)

            "ю" -> { if (isUpperCase) { "Yu" } else { "yu" } }

            "я" -> { if (isUpperCase) { "Ya" } else { "ya" } }

            else -> handleLetterCase(letter, isUpperCase)
        }
    }

    fun handleLetterCase(letter: String, isUpperCase: Boolean): String {
        return if (isUpperCase) {
            letter.toUpperCase()
        } else {
            letter
        }
    }

}
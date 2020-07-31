package cli.app.bigram_parser.impl

import cli.app.bigram_parser.BigramParser
import cli.app.bigram_parser.ErrorConsts
import cli.app.bigram_parser.models.Bigram
import cli.app.error.BigramParsingError
import java.io.File

class BigramParserImpl: BigramParser {

    private var bigramList: MutableList<Bigram> = mutableListOf()

    override fun parseBigram(filePath: String): List<Bigram> {
        var text = ""

        File(filePath).forEachLine { text += it }

        val filteredText = filterSpecialCharsAndLowercaseText(text)
        val wordList = filteredText.split(" ")

        if (wordList.size > 1) {
            for (i in 0 until wordList.size - 1) {
                val inputBigram = Bigram(
                    firstWord = wordList[i],
                    secondWord = wordList[i + 1]
                )
                bigramList = addBigram(inputBigram = inputBigram)
            }
        } else {
            throw BigramParsingError(message = ErrorConsts.FEWER_THAN_TWO_WORDS_PROVIDED)
        }

        printBigramList()

        return bigramList
    }

    private fun filterSpecialCharsAndLowercaseText(text: String): String {
        val filterChars = ".,;:!?><()"
        val filteredText = text.filterNot { filterChars.indexOf(it) > -1 }
        return filteredText.toLowerCase()
    }

    private fun addBigram(inputBigram: Bigram): MutableList<Bigram> {
        val elementIndex = bigramList.indexOf(inputBigram)
        if (elementIndex >= 0) {
            val oldBigram = bigramList[elementIndex]
            val newBigram = Bigram(
                firstWord = oldBigram.firstWord,
                secondWord = oldBigram.secondWord,
                count = oldBigram.count!! + 1
            )
            bigramList[elementIndex] = newBigram
        } else {
            bigramList.add(inputBigram)
        }
        return bigramList
    }

    private fun printBigramList() {
        for (bigram in bigramList) {
            println("\"${bigram.firstWord} ${bigram.secondWord}\" ${bigram.count}")
        }
    }
}

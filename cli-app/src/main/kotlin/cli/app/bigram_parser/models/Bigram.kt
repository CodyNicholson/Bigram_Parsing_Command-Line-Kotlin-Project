package cli.app.bigram_parser.models

import cli.app.bigram_parser.ErrorConsts
import cli.app.error.BigramParsingError

data class Bigram(val firstWord: String, val secondWord: String, var count: Int? = 1) {
    override fun equals(other: Any?): Boolean {
        try {
            val otherBigram = other as Bigram
            return this.firstWord == otherBigram.firstWord && this.secondWord == otherBigram.secondWord
        } catch (e: ClassCastException) {
            throw BigramParsingError(message = ErrorConsts.BIGRAM_CASTING_ERROR, cause = e)
        }
    }
}

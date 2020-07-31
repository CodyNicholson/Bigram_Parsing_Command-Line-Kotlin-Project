package cli.app.bigram_parser

object ErrorConsts {
    const val BIGRAM_CASTING_ERROR = "500 Internal Server Error - Could not cast provided input to bigram"
    const val FEWER_THAN_TWO_WORDS_PROVIDED = "400 Bad Request - Fewer than two words were provided"
    const val FILE_NOT_FOUND = "404 Not Found - File not found"
}
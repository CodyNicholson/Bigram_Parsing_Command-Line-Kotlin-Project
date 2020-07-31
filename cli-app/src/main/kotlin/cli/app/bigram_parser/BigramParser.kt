package cli.app.bigram_parser

import cli.app.bigram_parser.models.Bigram

interface BigramParser {
    fun parseBigram(text: String): List<Bigram>
}

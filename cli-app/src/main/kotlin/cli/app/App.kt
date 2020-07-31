/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package cli.app

import cli.app.bigram_parser.impl.BigramParserImpl
import kotlinx.cli.*

fun main(args: Array<String>) {
    val parser = ArgParser("file.txt")
    val filePath by parser.option(ArgType.String, shortName = "f", description = "File Path").default("filepath.txt")

    // Add all input to parser
    parser.parse(args)

    val app = App()
    if(filePath.isNotBlank()) {
        app.parseBigram(filePath)
    } else {
        println("You did not provide a valid filepath.")
    }
}

class App {
    val bigramParser = BigramParserImpl()

    public fun parseBigram(filePath: String) {
        bigramParser.parseBigram(filePath)
    }
}

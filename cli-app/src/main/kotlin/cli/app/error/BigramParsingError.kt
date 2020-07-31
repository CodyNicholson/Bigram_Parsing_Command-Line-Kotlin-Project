package cli.app.error

class BigramParsingError(
    message: String?,
    cause: Throwable? = null
) : RuntimeException(message, cause)

package math.functions.domains

import java.lang.RuntimeException

data class IncorrectDomainException(val functionName: String) : RuntimeException(
    "Incorrect domain in function=$functionName",
)
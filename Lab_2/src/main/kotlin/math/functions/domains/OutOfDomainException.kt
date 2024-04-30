package math.functions.domains

import java.lang.RuntimeException

data class OutOfDomainException(val functionName: String) : RuntimeException(
    "Input is out of function=$functionName domain",
)
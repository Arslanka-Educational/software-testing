package task3.model

import task3.enum.LogicalSchemeState

data class LogicalScheme(
    val state: LogicalSchemeState = LogicalSchemeState.ACTIVE
)
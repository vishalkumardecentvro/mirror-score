package com.myapp.mirrorscore.table

data class Report(
    val incorrectAnswer: Boolean,
    val incorrectQuestion: Boolean,
    val missingImage: Boolean,
    val missingOption: Boolean,
    val reportId: Int,
    val spellingMistake: Boolean
)
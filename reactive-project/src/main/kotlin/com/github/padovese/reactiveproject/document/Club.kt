package com.github.padovese.reactiveproject.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Club(
        @Id val id: String,
        val name: String
)
package com.padovese.projectcars.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Car(
        @Id
        val id: String?,
        val name: String
)

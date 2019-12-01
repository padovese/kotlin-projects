package com.gypsydanger.restapi.model

import com.gypsydanger.restapi.enumerator.Languages
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Book(@Id @GeneratedValue var id: Int, var name: String, var language: Languages)
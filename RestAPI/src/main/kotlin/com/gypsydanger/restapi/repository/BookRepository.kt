package com.gypsydanger.restapi.repository

import com.gypsydanger.restapi.model.Book
import org.springframework.data.repository.Repository
import java.util.*

interface BookRepository: Repository<Book, Int> {
    fun save(a: Book): Book
    fun findById(a: Int): Optional<Book>
    fun findAll(): List<Book>
    fun delete(a: Book)
}
package com.gypsydanger.restapi.service

import com.gypsydanger.restapi.enumerator.Languages
import com.gypsydanger.restapi.model.Book
import com.gypsydanger.restapi.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {

    fun getAll() = bookRepository.findAll()
    fun save(book: Book) = bookRepository.save(book)
    fun getById(id: Int): Book = bookRepository.findById(id).orElseThrow { KotlinNullPointerException("Book not Found!") }

    fun delete(id: Int) {
        val book = getById(id)
        bookRepository.delete(book)
    }

    fun changeLanguage(id: Int, language: Languages): Book {
        val book = getById(id)
        book.language = language
        return save(book)
    }
}
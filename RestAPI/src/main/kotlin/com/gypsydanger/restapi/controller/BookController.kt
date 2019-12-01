package com.gypsydanger.restapi.controller

import com.gypsydanger.restapi.enumerator.Languages
import com.gypsydanger.restapi.model.Book
import com.gypsydanger.restapi.repository.BookRepository
import com.gypsydanger.restapi.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("book")
class BookController(val bookService: BookService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody book: Book) = bookService.save(book)

    @GetMapping("{id}")
    fun getById(@PathVariable id: Int): Book = bookService.getById(id)

    @GetMapping("get-all")
    fun getAllBooks(): List<Book> = bookService.getAll()

    @PatchMapping("{id}")
    fun changeLanguage(@PathVariable id: Int, @RequestBody language: Languages): Book =
            bookService.changeLanguage(id, language)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int) = bookService.delete(id)

}
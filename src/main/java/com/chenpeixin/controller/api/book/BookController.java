package com.chenpeixin.controller.api.book;

import com.chenpeixin.dto.api.book.BookRequest;
import com.chenpeixin.model.Book;
import com.chenpeixin.service.api.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenpeixin
 * 2021-02-10
 */
@Validated
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService mBookService;

    @GetMapping("")
    public Page<Book> pageBooks(BookRequest request, Pageable pageable) {
        return mBookService.pageBooks(request, pageable);
    }

    @GetMapping("/{id}")
    public Book detailBook(@PathVariable Long id) {
        return mBookService.detailBook(id);
    }

    @GetMapping("/recommend")
    public List<Book> listBooks() {
        return mBookService.listRecommendBooks();
    }
}

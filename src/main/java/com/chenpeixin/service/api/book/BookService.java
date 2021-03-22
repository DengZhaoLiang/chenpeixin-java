package com.chenpeixin.service.api.book;

import com.chenpeixin.dto.api.book.BookRequest;
import com.chenpeixin.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author chenpeixin
 * 2021-02-10
 */
public interface BookService {

    /**
     * 获取书
     */
    Page<Book> pageBooks(BookRequest request, Pageable pageable);

    /**
     * 获取书详情
     */
    Book detailBook(Long id);

    /**
     * 获取推荐的书籍
     */
    List<Book> listRecommendBooks();
}

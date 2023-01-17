package com.azamakram.github.springbootcassandradocker.service;

import com.azamakram.github.springbootcassandradocker.model.input.BookStoreInput;
import com.azamakram.github.springbootcassandradocker.model.output.BookStoreOutput;

import java.util.List;
import java.util.UUID;

public interface BookStoreService {
    List<BookStoreOutput> getAllBookStores();

    BookStoreOutput getBookStoreById(UUID id);

    BookStoreOutput saveBookStore(BookStoreInput input);

    BookStoreOutput updateBookStore(BookStoreInput input);

    void deleteBookStore(UUID id);
}

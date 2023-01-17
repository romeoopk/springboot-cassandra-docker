package com.azamakram.github.springbootcassandradocker.service;

import com.azamakram.github.springbootcassandradocker.model.entity.BookStoreEntity;
import com.azamakram.github.springbootcassandradocker.model.exception.BookNotFoundException;
import com.azamakram.github.springbootcassandradocker.model.input.BookStoreInput;
import com.azamakram.github.springbootcassandradocker.model.output.BookStoreOutput;
import com.azamakram.github.springbootcassandradocker.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class BookStoreServiceImpl implements BookStoreService {

    @Autowired
    private BookStoreRepository bookStoreRepository;

    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<BookStoreOutput> getAllBookStores() {
        return ModelConverterUtil.convertEntityListToOutputList(bookStoreRepository.findAll());
    }

    @Override
    public BookStoreOutput getBookStoreById(UUID id) {
        return bookStoreRepository.findByUuid(id)
            .map(entity -> ModelConverterUtil.convertEntityToOutput(entity))
            .orElseThrow( ()-> new BookNotFoundException(String.format("Book not found for id: %s", id)));
    }

    @Override
    public BookStoreOutput saveBookStore(BookStoreInput input) {
        BookStoreEntity entity = ModelConverterUtil.convertInputToEntity(input);
        BookStoreEntity saved = bookStoreRepository.save(entity);
        if(saved == null) {
            throw new NullPointerException();
        }
        return ModelConverterUtil.convertEntityToOutput(saved);
    }

    @Override
    public BookStoreOutput updateBookStore(BookStoreInput input) {
        return ModelConverterUtil.convertEntityToOutput(
                bookStoreRepository.save(
                        ModelConverterUtil.convertInputToEntity(input)));
    }

    @Override
    public void deleteBookStore(UUID uuid) {
        bookStoreRepository.deleteById(uuid);
    }

}
package com.azamakram.github.springbootcassandradocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.azamakram.github.springbootcassandradocker.model.input.BookStoreInput;
import com.azamakram.github.springbootcassandradocker.service.BookStoreService;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/books")
public class BookStoreController {
 
    @Autowired
    BookStoreService bookStoreService;
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllBooks() {
        log.trace("Reading all books");
        return new ResponseEntity<>(bookStoreService.getAllBookStores(), HttpStatus.OK);
    }

    @GetMapping(path = "/{uuid}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBookById(@PathVariable(value = "uuid") final UUID uuid) {
        log.trace("Reading book information by Id");
        return new ResponseEntity<>(bookStoreService.getBookStoreById(uuid), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveBook(@Valid @RequestBody final BookStoreInput input) {
        log.trace("Saving book");
        return new ResponseEntity<>(bookStoreService.saveBookStore(input), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateBook(@Valid @RequestBody final BookStoreInput input) {
        log.trace("Update book");
        return new ResponseEntity<>(bookStoreService.updateBookStore(input), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{uuid}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "uuid") final UUID uuid) {
        log.trace("Update book");
        bookStoreService.deleteBookStore(uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
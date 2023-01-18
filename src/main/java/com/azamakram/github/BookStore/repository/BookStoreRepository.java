package com.azamakram.github.BookStore.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.azamakram.github.BookStore.model.entity.BookStore;

import java.util.Optional;
import java.util.UUID;

@Repository("bookstore")
public interface BookStoreRepository extends CassandraRepository<BookStore, UUID> {
    Optional<BookStore> findByUuid(UUID uuid);
}

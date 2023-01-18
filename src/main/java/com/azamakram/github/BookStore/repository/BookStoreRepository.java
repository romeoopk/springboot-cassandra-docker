package com.azamakram.github.BookStore.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.azamakram.github.BookStore.model.entity.BookStoreEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookStoreRepository extends CassandraRepository<BookStoreEntity, UUID> {
    Optional<BookStoreEntity> findByUuid(UUID uuid);
}

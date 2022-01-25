package com.example.demo.repository;

import com.example.demo.entity.TransactionLogger;
import org.springframework.data.repository.CrudRepository;

public interface TransactionLoggerRepository extends CrudRepository<TransactionLogger,Long> {
}

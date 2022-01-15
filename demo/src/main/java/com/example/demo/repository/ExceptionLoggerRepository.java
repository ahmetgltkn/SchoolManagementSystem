package com.example.demo.repository;

import com.example.demo.entity.ExceptionsLogger;
import org.springframework.data.repository.CrudRepository;

public interface ExceptionLoggerRepository extends CrudRepository<ExceptionsLogger,Long> {
}

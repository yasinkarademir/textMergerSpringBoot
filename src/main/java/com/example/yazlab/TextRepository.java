package com.example.yazlab;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TextRepository extends MongoRepository<TextEntity, String> {
}

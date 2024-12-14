package com.example.journalEntryWithDb.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.journalEntryWithDb.entity.UserEntity;



public interface UserRepository extends MongoRepository<UserEntity, ObjectId> {
    UserEntity findByUsername(String username);
}

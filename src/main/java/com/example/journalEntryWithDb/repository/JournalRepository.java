package com.example.journalEntryWithDb.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.journalEntryWithDb.entity.JournalDBEntity;

public interface JournalRepository extends MongoRepository<JournalDBEntity, ObjectId> {

}

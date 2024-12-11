package com.example.journalEntryWithDb.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

// declaring this document as a mongodb document
@Document(collection = "journal_db")
@Getter
@Setter
public class JournalDBEntity {
    private ObjectId id;
    private String title;
    private String content;

    // Getter and Setter methods
    // public ObjectId getId() {
    //     return id;
    // }
    // public void setId(ObjectId id) {
    //     this.id = id;
    // }
    // public String getTitle() {
    //     return title;
    // }
    // public void setTitle(String title) {
    //     this.title = title;
    // }
    // public String getContent() {
    //     return content;
    // }
    // public void setContent(String content) {
    //     this.content = content;
    // }
    
    
}

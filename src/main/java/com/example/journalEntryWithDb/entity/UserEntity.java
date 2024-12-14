package com.example.journalEntryWithDb.entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    private ObjectId id;
    
    @Indexed(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String password;
    // storing references of JournalDBEntity
    @DBRef
    private List<JournalDBEntity>journals = new ArrayList<>();
}

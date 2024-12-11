package com.example.journalEntryWithDb.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.journalEntryWithDb.entity.JournalDBEntity;
import com.example.journalEntryWithDb.repository.JournalRepository;

@Component
public class JournalDbService {

    @Autowired
    private JournalRepository journalRepository;

    // Save a journal
    public void saveJournal(JournalDBEntity journalDBEntity) {
        System.out.println("Saving journal: " + journalDBEntity);
        journalRepository.save(journalDBEntity);
    }

    // Delete a journal
    public void deleteJournal(ObjectId id) {
        journalRepository.deleteById(id);
    }

    // Finds journal by id
    public JournalDBEntity findJournal(ObjectId id) throws Exception {
        // One way to get the Journal value using try and catch
        // try {
        //     return journalRepository.findById(id).get();
        // } catch (NoSuchElementException e) {
        //     throw new Exception("Journal not found");
        // }

        // Another way to get the Journal value using Optional
        return journalRepository.findById(id).orElseThrow(()->new Exception("Journal not found"));
    }

    // Returns a list of all journals
    public List<JournalDBEntity> getAllJournals() {
        return journalRepository.findAll();
    }
}

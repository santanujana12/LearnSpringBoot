package com.example.journalEntryWithDb.service;

import java.util.List;
import java.util.Optional;

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

    // Update a journal
    public Boolean updateJournal(ObjectId id, JournalDBEntity journalDBEntity) throws Exception {
        Optional<JournalDBEntity> journals = journalRepository.findById(id);
        if(journals.isPresent()){
            // Take the found data using ID
            JournalDBEntity journal = journals.get();
            // Take from the request and ovrwrite the data
            journal.setTitle(journalDBEntity.getTitle());
            journal.setContent(journalDBEntity.getContent());
            journalRepository.save(journal);
            return true;
        }
        return false;
    }
}

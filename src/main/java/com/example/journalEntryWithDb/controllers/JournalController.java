package com.example.journalEntryWithDb.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.example.journalEntryWithDb.entity.JournalDBEntity;
import com.example.journalEntryWithDb.service.JournalDbService;

@RestController
@RequestMapping("/api/journal")
public class JournalController {

    @Autowired
    private JournalDbService journalDbService;

    // Method to insert into journal db
    @PostMapping("/saveJournal")
    public ResponseEntity<Boolean> saveJournal(@RequestBody JournalDBEntity journalDBEntity) {
        journalDbService.saveJournal(journalDBEntity);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    // Get all journals by Id
    // If a method in the service throws exception it needs to be handled in the
    // controller part also
    @GetMapping("/getById")
    public ResponseEntity<JournalDBEntity> getAll(@PathVariable ObjectId id) {
        try {
            return ResponseEntity.ok().body(journalDbService.findJournal(id));
        } catch (Exception e) {
            // handle the exception here
            // for example, you can log the exception or return a default value

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // List all data present in DB
    @GetMapping("/getAll")
    public ResponseEntity<List<JournalDBEntity>> getAll() {
        try {
            List<JournalDBEntity> journalList = journalDbService.getAllJournals();
            return new ResponseEntity<>(journalList, HttpStatus.OK);
        } catch (Exception e) {
            // Optionally log the exception here
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    // Delete a particular journal by ID
    @DeleteMapping("/deleteJournal/{id}")
    public Boolean deleteJournal(@PathVariable ObjectId id) {
        journalDbService.deleteJournal(id);
        return true;
    }

    // Updating the journal by ID
    @PutMapping("/updateJournal/{id}")
    public ResponseEntity<Boolean> updateJournal(@PathVariable ObjectId id, @RequestBody JournalDBEntity journalDBEntity) {
        try{
            // Returns true or false because in service layer the method is a boolean function
            if(journalDbService.updateJournal(id, journalDBEntity)){
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

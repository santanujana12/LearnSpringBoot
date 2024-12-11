package com.journalApp.Journal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journalApp.Journal.entity.JournalEntry;

// Controllers are special type of beans that are used to handle http requests.

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    
    private Map<Integer, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/entries")
    public Map<Integer, JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    // Expects a JournalEntry object in the request body 
    @PostMapping("/addEntries")
    public Map<Integer, JournalEntry> addJournalEntries(@RequestBody JournalEntry journalEntry) {
        System.out.println(journalEntry.getId());
        // Add GetId which returns id as the first parameter in Map 
        journalEntries.put(journalEntry.getId(), journalEntry);
        return journalEntries;
    }

    // Finding specific JournalEntry
    @GetMapping("/id/{myId}")
    public JournalEntry getJournalById(@PathVariable int myId) {
        return journalEntries.get(myId);
    }

    // Delete mapping
    @DeleteMapping("/delete/{myId}")
    public JournalEntry deleteJournalById(@PathVariable int myId) {
        return journalEntries.remove(myId);
    }

    // Update mapping
    @PutMapping("/update/{myId}")
    public JournalEntry updateJournalById(@PathVariable int myId, @RequestBody JournalEntry journalEntry) {
        journalEntries.put(myId, journalEntry);
        return journalEntries.get(myId);
    }
}

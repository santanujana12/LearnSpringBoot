package com.example.journalEntryWithDb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.journalEntryWithDb.entity.JournalDBEntity;
import com.example.journalEntryWithDb.entity.UserEntity;
import com.example.journalEntryWithDb.repository.JournalRepository;
import com.example.journalEntryWithDb.repository.UserRepository;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JournalRepository journalRepository;

    // Returns a list of All users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Find an user with username
    public UserEntity findByUsername(String username){
       return userRepository.findByUsername(username);
    }

    // Add an user
    public Boolean addUser(UserEntity userEntity, String username){
        // Find if the particular username already exists
        UserEntity user = userRepository.findByUsername(username);

        // Handle the case if the username already exists
        if(user==null){
            userRepository.save(userEntity);
            return true;
        }else{
            return false;
        }
    }

    // Update an user
    // overwriting the Journal data
    public Boolean updateUser(UserEntity userEntity, String username) {
        UserEntity user = userRepository.findByUsername(username);
        if(user!=null){
            user.setUsername(userEntity.getUsername());
            user.setPassword(userEntity.getPassword());
            userRepository.save(user);
            return true;
        }else{
            return false;
        }
    }

    // Save an user with journal reference
    public Boolean saveUserWithJournal(UserEntity user){
        userRepository.save(user);
        return true;
    }

    // Delete an user
    // Make this transaction atomic that means if either of the operations fail journal/user then both should be rolled back
    @Transactional
    public Boolean deleteUser(String username) {
        UserEntity user  = userRepository.findByUsername(username);
        if(user!=null){
           
            for(JournalDBEntity journal : user.getJournals()){
                journalRepository.deleteById(journal.getId());
            }
            userRepository.delete(user);
            return true;
        }
        return false;
    }
}

package com.example.journalEntryWithDb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//Helps in creating transaction that have @transactional annotation to be atomic
@EnableTransactionManagement
public class JournalEntryWithDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalEntryWithDbApplication.class, args);
	}

}

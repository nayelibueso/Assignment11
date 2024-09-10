package com.codercampus.Assignment11.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	
	private final TransactionRepository transactionRepo;
	
	@Autowired
	public TransactionService(TransactionRepository transactionRepo) { // Constructor for dependency issues
		this.transactionRepo = transactionRepo;
	}

	public List<Transaction> findAll() {
		return transactionRepo.findAll().stream()
							  .sorted((t1, t2)-> t1.getDate().compareTo(t2.getDate())) //Sorting by date in ascending order
							  .collect(Collectors.toList());
	}

	public Transaction findById(Long transactionId) {
		return transactionRepo.findAll().stream()
					           .filter(transaction -> transaction.getId().equals(transactionId))
					           .findFirst()
					           .orElseThrow(() -> new RuntimeException("Transaction not found"));
	}

	//Adding method 
//	public Transaction getTransactionById(Long transactionId) {
//		return transactionRepo.finById;
//	}

}

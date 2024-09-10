package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionalController {

	private final TransactionService transactionService;

	@Autowired
	public TransactionalController(TransactionService transactionService) { // Constructor injection
		this.transactionService = transactionService;
	}

	@GetMapping("/transactions")
	public String getAllTransactions(Model model) { // Responsible for fetching all transactions and them to the view.
		model.addAttribute("transactions", transactionService.findAll());
		return "transactions";
	}
	
	@GetMapping("/transactions/{transactionId}")
	public String getTransactionDetail (@PathVariable Long transactionId, Model model) {
		Transaction selectedTransaction = transactionService.getTransactionById(transactionId);//need to create method
		model.addAttribute("selectedTransaction", selectedTransaction);
		return "transaction-detail";
	}

}
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
	public TransactionalController(TransactionService transactionService) { 
		this.transactionService = transactionService;
	}

	@GetMapping("/transactions")
	public String getAllTransactions(Model model) { 
		model.addAttribute("transactions", transactionService.findAll());
		return "transactions";
	}
	
	@GetMapping("/transactions/{transactionId}")
	public String getTransactionDetail (@PathVariable Long transactionId, Model model) {
		Transaction selectedTransaction = transactionService.findById(transactionId);
		model.addAttribute("selectedTransaction", selectedTransaction);
		return "transactionDetail";
	}

}
package com.codercampus.Assignment11.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
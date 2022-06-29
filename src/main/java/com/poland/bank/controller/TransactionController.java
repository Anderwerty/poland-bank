package com.poland.bank.controller;

import com.poland.bank.service.TransactionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.poland.bank.controller.Methods.GET;

public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(url = "/bank/transaction/all", method = GET)
    public void getAllTransaction(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("transactions", transactionService.findAll());
    }

}



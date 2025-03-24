package com.example.final_exam_module4.controller;


import com.example.final_exam_module4.entity.Transaction;
import com.example.final_exam_module4.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @GetMapping("")
    public String index(
            Model model,
            @RequestParam(name = "searchByName", defaultValue = "") String searchByName,
            @RequestParam(name = "page", defaultValue = "0") int page
    ) {

        if (page > 0) {
            page = page - 1;
        }

        Page<Transaction> transactions = transactionService.findByCustomerNameContainingIgnoreCase(searchByName, PageRequest.of(page, 20));

        if (transactions.isEmpty()) {
            model.addAttribute("message", "Không tìm thấy dữ liệu");
        }

        String queryParams = "searchByName=" + searchByName;

        model.addAttribute("transactions", transactions);
        model.addAttribute("queryParams", queryParams);

        return "transaction/list";
    }


}

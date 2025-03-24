package com.example.final_exam_module4.controller;


import com.example.final_exam_module4.entity.Customer;
import com.example.final_exam_module4.entity.Transaction;
import com.example.final_exam_module4.service.ICustomerService;
import com.example.final_exam_module4.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String index(
            Model model,
            @RequestParam(name = "searchByName", defaultValue = "") String searchByName,
            @RequestParam(name = "page", defaultValue = "0") int page
    ) {

        if (page > 0) {
            page = page - 1;
        }

        Page<Transaction> transactions = transactionService.findByCustomerNameContainingIgnoreCase(searchByName, PageRequest.of(page, 3));

        if (transactions.isEmpty()) {
            model.addAttribute("message", "Không tìm thấy dữ liệu");
        }

        String queryParams = "searchByName=" + searchByName;

        model.addAttribute("transactions", transactions);
        model.addAttribute("queryParams", queryParams);

        return "transaction/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Transaction transaction = new Transaction();
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        model.addAttribute("transaction", transaction);
        return "transaction/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        transactionService.remove(id);
        redirect.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/transaction";
    }

    @PostMapping("/save")
    public String save (
            @RequestParam (name = "typeService") String typeService,
            @RequestParam (name = "customerid") Long customerId,
            @Validated @ModelAttribute Transaction transaction,
            BindingResult bindingResult,
            RedirectAttributes redirect,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("transaction", transaction);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "transaction/create";
        }

        transaction.setTypeService(typeService);
        Customer customer = customerService.findById(customerId);
        transaction.setCustomer(customer);
        transactionService.save(transaction);
        redirect.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/transaction";




    }

}

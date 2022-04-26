package com.fuad.springpractice.controllers;

import com.fuad.springpractice.service.Account;
import com.fuad.springpractice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ModelAndView helloWorld() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "Khalid Saifullah Fuad");
        mv.setViewName("hello");
        return mv;
    }

    @GetMapping("/hello")
    public String displayHello(Model model, @RequestParam(name = "name", defaultValue = "") String name) {
        model.addAttribute("name", name.isBlank() ? "World" : name);
        return "hello";
    }

    @GetMapping("/accountdetails")
    public String displayAccountDetails(Model model) {
        Account account = accountService.getAccountDetails();

        model.addAttribute("id", account.getAccountId());
        model.addAttribute("name", account.getAccountHolderName());
        model.addAttribute("type", account.getAccountType());
        return "account_details";
    }
}


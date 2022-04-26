package com.fuad.springpractice.config;

import com.fuad.springpractice.service.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.fuad.springpractice.service"})
public class RootConfig {

    @Bean
    public Account accountDetails() {
        Account account = new Account();
        account.setAccountId("3456839681");
        account.setAccountType("Business");
        account.setAccountHolderName("Khalid Saifullah Fuad");
        return account;
    }

}


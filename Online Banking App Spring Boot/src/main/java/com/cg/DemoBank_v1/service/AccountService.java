package com.cg.demoBank.service;

import com.cg.demoBank.models.Account;
import com.cg.demoBank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public BigDecimal getAccountBalance(String userId, String accountId) {
        Account account = accountRepository.findByUserIdAndAccountId(userId, accountId);
        return account != null ? account.getBalance() : BigDecimal.ZERO;
    }

    public void changeAccountsBalanceById(BigDecimal newBalance, String accountId) {
        List<Account> accounts = accountRepository.findAll();
        for (Account acc : accounts) {
            if (acc.getAccountId().equals(accountId)) {
                acc.setBalance(newBalance);
                accountRepository.save(acc);
                break;
            }
        }
    }

    public List<Account> getUserAccountsById(String userId) {
        return accountRepository.findByUserId(userId);
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }
}

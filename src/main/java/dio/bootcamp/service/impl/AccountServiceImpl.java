package dio.bootcamp.service.impl;

import dio.bootcamp.domain.model.Account;
import dio.bootcamp.domain.repository.AccountRepository;
import dio.bootcamp.service.AccountService;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Account create(Account newAccount) {
        if (accountRepository.existsByRegistration(newAccount.getRegistration())) {
            throw new IllegalArgumentException("This account is already registered!");
        }
        return accountRepository.save(newAccount);
    }
}

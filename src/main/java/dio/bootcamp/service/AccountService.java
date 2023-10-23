package dio.bootcamp.service;

import dio.bootcamp.domain.model.Account;

public interface AccountService {
  Account findById(Long id);

  Account create(Account newAccount);
}

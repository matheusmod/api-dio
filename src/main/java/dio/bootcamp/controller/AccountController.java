package dio.bootcamp.controller;

import dio.bootcamp.domain.model.Account;
import dio.bootcamp.service.AccountService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/accounts")
public class AccountController {

  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Account> findById(@PathVariable Long id) {
    var user = accountService.findById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping
  public ResponseEntity<Account> create(@RequestBody Account newAccount) {
    var userCreated = accountService.create(newAccount);
    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(userCreated.getId())
      .toUri();
    return ResponseEntity.created(location).body(userCreated);
  }
}

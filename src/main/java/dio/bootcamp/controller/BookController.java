package dio.bootcamp.controller;

import dio.bootcamp.domain.model.Book;
import dio.bootcamp.service.BookService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> findById(@PathVariable Long id) {
    var user = bookService.findById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping
  public ResponseEntity<Book> create(@RequestBody Book newBook) {
    var userCreated = bookService.create(newBook);
    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(userCreated.getId())
      .toUri();
    return ResponseEntity.created(location).body(userCreated);
  }
}

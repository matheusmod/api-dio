package dio.bootcamp.service;

import dio.bootcamp.domain.model.Book;

public interface BookService {
    Book findById(Long id);

    Book create(Book newBook);

    void delete(Long id);
}

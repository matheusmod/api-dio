package dio.bootcamp.service.impl;

import dio.bootcamp.domain.model.Book;
import dio.bootcamp.domain.repository.BookRepository;
import dio.bootcamp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Book create(Book newBook) {
        if (newBook.getId() != null && bookRepository.existsById(newBook.getId())) {
            throw new IllegalArgumentException("This Book is already registered!");
        }
        return bookRepository.save(newBook);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}

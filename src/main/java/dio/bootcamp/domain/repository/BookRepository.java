package dio.bootcamp.domain.repository;

import dio.bootcamp.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

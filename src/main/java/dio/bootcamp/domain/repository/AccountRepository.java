package dio.bootcamp.domain.repository;

import dio.bootcamp.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByRegistration(String registration);
}

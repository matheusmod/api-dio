package dio.bootcamp.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Account> accounts;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books;
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

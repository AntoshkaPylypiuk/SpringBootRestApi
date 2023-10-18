package ua.lv.pylypiuk.anton.RESTapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lv.pylypiuk.anton.RESTapi.model.Book;

public interface BooksRepository extends JpaRepository <Book, Long> {
}

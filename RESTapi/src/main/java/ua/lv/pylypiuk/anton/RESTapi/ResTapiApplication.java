package ua.lv.pylypiuk.anton.RESTapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.lv.pylypiuk.anton.RESTapi.model.Book;
import ua.lv.pylypiuk.anton.RESTapi.repository.BooksRepository;

@SpringBootApplication
public class ResTapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResTapiApplication.class, args);
	}

	@Autowired
	private BooksRepository booksRepository;

}

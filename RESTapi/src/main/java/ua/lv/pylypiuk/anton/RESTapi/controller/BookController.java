package ua.lv.pylypiuk.anton.RESTapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lv.pylypiuk.anton.RESTapi.exception.ResourceNotFoundException;
import ua.lv.pylypiuk.anton.RESTapi.model.Book;
import ua.lv.pylypiuk.anton.RESTapi.repository.BooksRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @Autowired
    private BooksRepository booksRepository;

    @GetMapping
    public List<Book> getAllBooks(){
        return booksRepository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return booksRepository.save(book);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id){
        Book book = booksRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException
                        ("Book does not exist with id: " + id));
        return ResponseEntity.ok(book);
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book bookInfo){
        Book updateBook = booksRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Book does not exist with id: " + id));

        updateBook.setName(bookInfo.getName());
        updateBook.setReleaseDate(bookInfo.getReleaseDate());
        updateBook.setGenre(bookInfo.getGenre());
        updateBook.setAuthor(bookInfo.getAuthor());

        booksRepository.save(updateBook);

        return ResponseEntity.ok(updateBook);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable long id){
        Book book = booksRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Book does not exist with id: " + id));

        booksRepository.delete(book);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

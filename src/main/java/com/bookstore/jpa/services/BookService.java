package com.bookstore.jpa.services;

import com.bookstore.jpa.dto.BookDTO;
import com.bookstore.jpa.models.Book;
import com.bookstore.jpa.models.Review;
import com.bookstore.jpa.repositories.AuthorRepository;
import com.bookstore.jpa.repositories.BookRepository;
import com.bookstore.jpa.repositories.PublisherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book saveBook(BookDTO bookDTO) throws Exception {
        try {
            Book book = new Book();
            book.setTitle(bookDTO.title());
            book.setPublisher(publisherRepository.findById(bookDTO.publisherId()).get());
            book.setAuthors(authorRepository.findAllById(bookDTO.authorIds()).stream().collect(Collectors.toSet()));

            Review review = new Review();
            review.setComment(bookDTO.reviewComment());
            review.setBook(book);
            book.setReview(review);

            return bookRepository.save(book);
        } catch (Exception err) {
            throw new Exception("An error has occurred");
        }
    }

    @Transactional
    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}

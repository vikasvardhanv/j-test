package com.graphqljava.tutorial.bookDetails;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @QueryMapping
    public Book bookDetails(@Argument BookFilter filter) {
        Map<String, Author> authors = Book.readAuthorsFromFile("path/to/your/authors.txt"); // Replace with actual file path
        Book book = Book.getById(filter.getId(), authors);
        return book;
    }
}

class BookFilter {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


---------------


package com.graphqljava.tutorial.bookDetails;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookDetailsRepository {

    private final List<Book> books;
    private final List<Author> authors;

    public BookDetailsRepository() {
        books = new ArrayList<>();
        authors = new ArrayList<>();
        loadBooksFromFile("books.txt"); // Replace "books.txt" with the actual file name containing book details
        loadAuthorsFromFile("authors.txt"); // Replace "authors.txt" with the actual file name containing author details
    }

    private void loadBooksFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Book book = new Book(parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim()), parts[3].trim());
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAuthorsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Author author = new Author(parts[0].trim(), parts[1].trim(), parts[2].trim());
                    authors.add(author);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public Author getAuthorById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }
}

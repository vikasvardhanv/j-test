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
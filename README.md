# j-test

package com.graphqljava.tutorial.bookDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book {

    private String id;
    private String name;
    private int pageCount;
    private String authorId;
    private Author author;

    // Constructor
    public Book(String id, String name, int pageCount, String authorId) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.authorId = authorId;
        this.author = null; // Initialize author to null
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    // Sample author data (replace with your actual author data retrieval logic)
    public static Map<String, Author> authors = new HashMap<>();

    public static void initializeAuthors() {
        authors.put("author-1", new Author("author-1", "J.K. Rowling"));
        authors.put("author-2", new Author("author-2", "Herman Melville"));
        authors.put("author-3", new Author("author-3", "Anne Rice"));
    }

    public static Book getById(String id) {
        Book book = null;
        for (Book b : getAllBooks()) {
            if (b.getId().equals(id)) {
                book = b;
                break;
            }
        }
        return book;
    }

    public static List<Book> getAllBooks() {
        // Replace with your actual logic to retrieve all books from your data source
        List<Book> books = new ArrayList<>();
        // ... Logic to populate the list with books from your data source
        return books;
    }
}

class Author {
    private String id;
    private String name;

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters (similar to Book class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

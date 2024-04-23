package com.graphqljava.tutorial.bookDetails;

import java.util.HashMap;
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

    // Sample method to read authors from a file (replace with your actual implementation)
    public static Map<String, Author> readAuthorsFromFile(String filePath) {
        // Implement logic to read author data (id, firstName, lastName) from the specified file
        // and populate a Map<String, Author> where key is authorId and value is Author object
        // This is a sample implementation, replace it with your file reading logic
        Map<String, Author> authors = new HashMap<>();
        authors.put("author-1", new Author("author-1", "Joanne", "Rowling"));
        authors.put("author-2", new Author("author-2", "Herman", "Melville"));
        authors.put("author-3", new Author("author-3", "Anne", "Rice"));
        return authors;
    }

    // Call by reference to populate author based on authorId
    public void populateAuthor(Map<String, Author> authors) {
        this.author = authors.get(this.authorId);
    }

    public static Book getById(String id, Map<String, Author> authors) {
        Book book = null;
        for (Book b : getAllBooks()) {
            if (b.getId().equals(id)) {
                book = b;
                book.populateAuthor(authors); // Call by reference to populate author
                break;
            }
        }
        return book;
    }

    // Sample logic for getAllBooks (replace with your actual data retrieval)
    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        // ... Logic to populate the list with books from your data source
        return books;
    }
}

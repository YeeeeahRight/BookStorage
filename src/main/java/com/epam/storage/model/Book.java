package com.epam.storage.model;

public class Book {
    private final String author;
    private final String title;
    private final String publisher;
    private final int yearCreation;
    private final int pages;

    public Book(String title, String author, String publisher, int yearCreation, int pages) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.yearCreation = yearCreation;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYearCreation() {
        return yearCreation;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }

        Book book = (Book) o;

        if (getYearCreation() != book.getYearCreation()) {
            return false;
        }
        if (getPages() != book.getPages()) {
            return false;
        }
        if (!getAuthor().equals(book.getAuthor())) {
            return false;
        }
        if (!getTitle().equals(book.getTitle())) {
            return false;
        }
        return getPublisher().equals(book.getPublisher());
    }
}

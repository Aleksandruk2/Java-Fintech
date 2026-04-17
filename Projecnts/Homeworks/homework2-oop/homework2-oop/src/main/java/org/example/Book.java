package org.example;

public class Book {
    private String name;
    private String authorName;
    private int year;
    private String publisherName;
    private String bookGenre;
    private int pages;

    public Book() {
        this.name = "";
        this.authorName = "";
        this.year = 0;
        this.publisherName = "";
        this.bookGenre = "";
        this.pages = 0;
    }

    public Book(String name, String authorName, int year, String publisherName, String bookGenre, int pages) {
        this.name = name;
        this.authorName = authorName;
        this.year = year;
        this.publisherName = publisherName;
        this.bookGenre = bookGenre;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return String.format("Book (name: %s, authorName: %s, year: %s, publisherName: %s, bookGenre: %s, pages: %s)", name, authorName, year, publisherName, bookGenre, pages);
    }
}
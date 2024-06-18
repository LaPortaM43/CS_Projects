package edu.monmouth.book;

import java.util.Calendar;
import java.util.Objects;

public class Book {
    
    private double price; 
    private BookTypes bookType; 
    private int numberOfPages;
    private String title; 
    private double publicationYear; 
    
    // Make preconditions for setters 
    public Book(String title, BookTypes bookType, int NumberOfPages, 
            double price, double publicationYear) throws BookException {
        
        setNumberOfPages(NumberOfPages);
        setBookType(bookType);
        setTitle(title);
        setPrice(price);
        setPublicationYear(publicationYear);
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) throws BookException {
        if (price < BookConstants.PRICEMIN) {
            throw new BookException("Price cannot be negative.");
        }
        this.price = price;
    }
    
    public BookTypes getBookType() {
        return bookType;
    }

    public void setBookType(BookTypes bookType) {
        this.bookType = bookType;
    }
    
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages) throws BookException {
        if (numberOfPages <= BookConstants.PAGES_MIN) {
            throw new BookException("Number of pages must be positive.");
        }
        
        this.numberOfPages = numberOfPages;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) throws BookException {
        this.title = title;
    }
    public double getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(double publicationYear) throws BookException {
        if (publicationYear < BookConstants.PUBLICATION_YEAR_MIN) {
            throw new BookException("Publication year cannot be negative.");
        }
        
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        
        if (publicationYear > currentYear + BookConstants.MAX_YEARS_IN_FUTURE) {
            throw new BookException("Publication year cannot be more than 2 years in the future.");
        }
        
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Book [price=" + price + ", bookType=" + bookType + 
                ", numberOfPages=" + numberOfPages + ", title="
                + title + ", publicationYear=" + publicationYear + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(title, other.title) &&
               numberOfPages == other.numberOfPages &&
               bookType == other.bookType;
    }
}


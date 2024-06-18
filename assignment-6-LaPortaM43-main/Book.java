package edu.monmouth.book;

import java.time.LocalDate;
import java.util.Objects;

public class Book implements Comparable<Book>{
    
    private double price; 
    private BookTypes bookType; 
    private int numberOfPages;
    private String title; 
    private LocalDate publicationYear; 
    
    // Make preconditions for setters 
    public Book(int numberOfPages, double price, String title, BookTypes bookType, int publicationYear) throws BookException {
        
        setNumberOfPages(numberOfPages);
        setPrice(price);
        setTitle(title);
        setBookType(bookType);
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
    public LocalDate getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) throws BookException {
        LocalDate publicationDate = LocalDate.of(publicationYear, 1, 1); 
        if (publicationDate.isAfter(LocalDate.now())) {
            throw new BookException("Publication year cannot be in the future.");
        }
        
        this.publicationYear = publicationDate;
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
        System.out.println("Invoking equals() method");
        return Objects.equals(title, other.title) &&
               numberOfPages == other.numberOfPages &&
               Objects.equals(bookType, other.bookType);
    }
    
    @Override
    public int hashCode() {
        System.out.println("Invoking hashCode() method");
        return Objects.hash(title, numberOfPages, bookType);
    }
    
    @Override
    public int compareTo(Book otherBook) {
    	final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        if (this == otherBook) {
            return EQUAL;
        }
        System.out.println("In Book's compareTo");
	    if (this.numberOfPages < otherBook.numberOfPages) { 
	    	return BEFORE;
	    }
	    
	    if (this.numberOfPages > otherBook.numberOfPages) { 
	    	return AFTER;
	    }
	    // numberOfPages are = order using bookType & title
	    if (this.bookType.compareTo(otherBook.bookType) == 0) {
	    // numberOfPages & bookType are = order using title
	    	return this.title.compareTo(otherBook.title); } 
	    else {
	    	return (this.bookType.compareTo(otherBook.bookType)); 
	    }
    }
}




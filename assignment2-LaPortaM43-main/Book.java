package edu.monmouth.book;

public class Book {
    
    private double price; 
    private BookTypes bookType; 
    private int numberOfPages;
    private String title; 
    private double publicationYear; 
    
    // Make preconditions for setters 
    public Book(int NumberOfPages, BookTypes bookType, String title, 
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
        if (numberOfPages < BookConstants.NUMBEROFPAGESMIN) { 
            this.numberOfPages = BookConstants.NUMBEROFPAGESMAX;
        } else { 
            this.numberOfPages = numberOfPages;
        }
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
    public void setPublicationYear(double publicationYear)throws BookException {
        if (publicationYear < BookConstants.PUBLICATIONYEARMIN) {
            throw new BookException("Publication year cannot be negative.");
        }
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Book [price=" + price + ", bookType=" + bookType + 
                ", numberOfPages=" + numberOfPages + ", title="
                + title + ", publicationYear=" + publicationYear + "]";
    }
}


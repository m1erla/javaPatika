package WeekFive.SortedBook;

import java.util.*;

public class Book implements Comparable<Book>{
    // Defined attributes
    private String bookName;
    private int pageNumber;
    private String author;
    private String releaseDate;

    // Created Constructor
    @Override
    public int compareTo(Book o) {
        return this.getBookName().compareTo(o.getBookName());
    }
    public Book(String bookName, int pageNumber, String author, String releaseDate){
        this.bookName= bookName;
        this.pageNumber = pageNumber;
        this.author= author;
        this.releaseDate = releaseDate;
    }
    // Getter and Setter methods
    public String getBookName(){
        return bookName;
    }
    public int getPageNumber(){
        return pageNumber;
    }
    public String getAuthor(){
        return author;
    }
    public String getReleaseDate(){
        return  releaseDate;
    }
    public void setBookName(String bookName){
        this.bookName = bookName;
    }
    public void setPageNumber(int pageNumber){
        this.pageNumber= pageNumber;
    }
    public void setAuthor(String author){
        this.author= author;
    }
    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }
    // A way to see that the whole list
    @Override
    public String toString(){
        return bookName.toUpperCase(Locale.ENGLISH) +
                " --- " + pageNumber +
                " --- " + author +
                " --- " + releaseDate;
    }



}



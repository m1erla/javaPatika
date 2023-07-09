package WeekSix.ListBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book {
    // Defined attributes and used encapsulation
    private String bookName;
    private int pageNumber;
    private String author;
    private String releaseDate;
// Constructor method
public Book(String bookName, String author, int pageNumber, String releaseDate){
    this.bookName = bookName;
    this.author = author;
    this.pageNumber = pageNumber;
    this.releaseDate = releaseDate;
}
    // Created run method for this class and defined static
    public static void run(){
      List<Book> library = new ArrayList<>();
        System.out.println("-".repeat(45));

        library.add(new Book("'Harry Poter' ", " Tyler Miles ", 545,"1/9/1876"));
      library.add(new Book("'Sherlock Holmes' ", " Patrick Nelson ", 487,"24/5/1983"));
      library.add(new Book("'The Witcher' ", " Idris Norton ", 765,"14/6/1994"));
      library.add(new Book("'Dark' ", " Kety Graze ", 344,"3/12/1844"));
      library.add(new Book("'The Batman' ", " Emma Swift ", 265,"30/11/2001"));
      library.add(new Book("'Life Circle' ", " Anna De Jackson ", 444,"3/4/2004"));
      library.add(new Book("'What If' ", " Jennifer Myers ", 354,"8/2/1967"));
      library.add(new Book("'The Lord of The Rings' ", " Tom Patrick ", 871,"21/7/1892"));
      library.add(new Book("'The Locker Key' ", " Ryan Evans ", 693,"19/8/1948"));
      library.add(new Book("'Paradise' ", " Chris Stone ", 805,"5/11/1999"));

      Map<String, String> tree = new TreeMap<>();

      library.forEach(book -> tree.put(book.getBookName(), book.getAuthor()));
      tree.forEach((bookName, author) -> System.out.println("The Book -> " + bookName + " - Author -> " + author));

      List<Book> filterPage = library.stream().filter(book -> book.getPageNumber() > 500).toList();
      System.out.println("-".repeat(45));
      System.out.println("List of books with more than 500 pages -> ");
      System.out.println("-".repeat(45));

      filterPage.forEach(book -> System.out.println("The Book -> " + book.getBookName() + "- Page -> " + book.getPageNumber()));

    }
    // Getter Setter Methods
    public  String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public  int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public  String getAuthor() {
        return author;
    }

    public  void setAuthor(String author) {
        this.author = author;
    }

    public  String getReleaseDate() {
        return releaseDate;
    }

    public  void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}

package WeekFive.SortedBook;

import java.util.*;

public class Main {

        public static void main(String[] args) {
            // Created a new object from book
            Book brand1 = new Book("Harry Poter", 455, "Tyler Jackson", "02/22/1976");
            Book brand2 = new Book("Sherlock Holmes", 321, "Mateo Tines", "06/15/1983");
            Book brand3 = new Book("Don't Look Up", 276, "Jennifer Stone", "04/07/1954");
            Book brand4 = new Book("Is That Okey", 487, "Mia Lawrance", "09/29/1994");
            Book brand5 = new Book("No Way Better Than You", 185, "Tom Gosling", "11/22/2002");
            // Using set data type and created new object for TreeSet
            Set<Book> brandBook = new TreeSet<>();
            // Addition to Books
            brandBook.add(brand1);
            brandBook.add(brand2);
            brandBook.add(brand3);
            brandBook.add(brand4);
            brandBook.add(brand5);

            System.out.println("-".repeat(20));
            System.out.println("List ordered by the name of books ");
            System.out.println("-".repeat(20));
            // Return whole list using with foreach loop
            for (Book sorted: brandBook) {
                System.out.println(sorted);
            }
            // Second set data type for Override to set up the ordered by page numbers
            Set<Book> sortedBook = new TreeSet<>(new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getPageNumber() - o2.getPageNumber();
                }
            });
            System.out.println("-".repeat(20));
            System.out.println("List ordered by the number of pages ");
            System.out.println("-".repeat(20));

            sortedBook.add(brand1);
            sortedBook.add(brand2);
            sortedBook.add(brand3);
            sortedBook.add(brand4);
            sortedBook.add(brand5);

            for (Book sorted : sortedBook) {
                System.out.println(sorted);
            }


        }
}

Book Sorter


Design a class called Book. Inherit from this class Comparable interface and override the "compareTo" method. Inside this method, write the code that sorts the book by name from A to Z. Create 5 objects of this class and store the objects in a Set type structure. Then use a Set type data structure a second time and have it sort the books by page count.


The Book class consists of the name of the book, the number of pages, the name of the author, and the date of publication.

    - Ordered by the number of pages
    
    @Override
    public int compareTo (Book o) {
        return this.getTotalPage() - o.getTotalPage();
    }

    - Ordered by the name of books

    @Override
    public int compareTo(Book o) {
        return this.getName().compareTo(o.getName());
    }

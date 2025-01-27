package hash.byobjectsutilarray;

import java.util.Objects;

public class Book extends hash.lowlevel.Book {

    public Book(String title, String author, int pages, boolean hardCover, double price) {
        super(title, author, pages, hardCover, price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages, hardCover, price);
    }
}

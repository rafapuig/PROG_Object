package hash.byObjectsUtil;

public class Book extends hash.lowlevel.Book {

    public Book(String title, String author, int pages, boolean hardCover, double price) {
        super(title, author, pages, hardCover, price);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = prime;
        hash = hash * prime + title.hashCode();
        hash = hash * prime + author.hashCode();
        hash = hash * prime + ((Object) pages).hashCode();
        hash = hash * prime + ((Object) hardCover).hashCode();
        hash = hash * prime + ((Object) price).hashCode();
        return hash;
    }
}

package hash.wrappersaidded;

public class Book extends hash.lowlevel.Book {

    public Book(String title, String author, int pages, boolean hardCover, double price) {
        super(title, author, pages, hardCover, price);
    }

    @Override
    public int hashCode() {
        int hash = 37;
        int code = 0;

        // Usamos el campo title
        code = title == null ? 0 : title.hashCode();
        hash = hash * 59 + code;

        // Usamos author
        code = author == null ? 0 : author.hashCode();
        hash = hash * 59 + code;

        // Usamos pages
        code = Integer.hashCode(pages);
        hash = hash * 59 + code;

        // Usamos hardCover
        code = Boolean.hashCode(hardCover);
        hash = hash * 59 + code;

        // Usamos price
        code = Double.hashCode(price);
        hash = hash * 59 + code;

        return hash;
    }
}

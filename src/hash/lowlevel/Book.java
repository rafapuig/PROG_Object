package hash.lowlevel;

public class Book {
    protected final String title;
    protected final String author;
    protected final int pages;
    protected final boolean hardCover;
    protected final double price;

    public Book(String title, String author, int pages, boolean hardCover, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.hardCover = hardCover;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public boolean isHardCover() {
        return hardCover;
    }

    public double getPrice() {
        return price;
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
        code = pages;
        hash = hash * 59 + code;

        // Usamos hardCover
        code = hardCover ? 1 : 0;
        hash = hash * 59 + code;

        // Usamos price
        long priceBits = Double.doubleToLongBits(price);
        code = (int) (priceBits ^ (priceBits >>> 32));
        hash = hash * 59 + code;

        return hash;
    }
}

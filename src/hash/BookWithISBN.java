package hash;

import hash.lowlevel.Book;

import java.util.Objects;

/**
 * Version de la clase Book con atributo ISBN
 * Dado que el ISBN identifica de forma única se puede usar simplemente para el cálculo del hash
 */
public class BookWithISBN extends Book {

    private final String ISBN;

    public BookWithISBN(String ISBN, String title, String author, int pages, boolean hardCover, double price) {
        super(title, author, pages, hardCover, price);
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }


    /**
     * Es suficiente con el campo ISBN para el cómputo del código hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }
}

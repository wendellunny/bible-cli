package Infra.Repositories.Mock;

import Domain.Entities.Bible;
import Domain.Entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements Domain.Api.Repositories.BookRepository {

    /**
     * Fetch all books from bible
     *
     * @param bible Bible
     * @return Book[]
     */
    @Override
    public List<Book> fetchByBible(Bible bible)
    {
        List<Book> books = new ArrayList<Book>();

        books.add(new Book(1, "Gênesis"));
        books.add(new Book(2, "Êxodo"));
        books.add(new Book(3, "Levítico"));
        books.add(new Book(4, "Números"));
        books.add(new Book(5, "Deutoronômio"));

        return books;
    }
}
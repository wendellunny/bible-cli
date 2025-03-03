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

        books.add(new Book(1, "Gênesis", bible));
        books.add(new Book(2, "Êxodo", bible));
        books.add(new Book(3, "Levítico", bible));
        books.add(new Book(4, "Números", bible));
        books.add(new Book(5, "Deutoronômio", bible));

        return books;
    }

    /**
     * Load book by id
     *
     * @param id int
     * @return Book
     */
    @Override
    public Book loadById(Bible bible, int id) {
        return new Book(1, "Gênesis", bible);
    }
}
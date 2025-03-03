package Infra.Repositories;

import Domain.Entities.Bible;
import Domain.Entities.Book;
import Infra.Api.Drivers.DbDriver;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements Domain.Api.Repositories.BookRepository
{
    protected static int ID_COLUMN = 0;
    protected static int NAME_COLUMN = 1;

    protected DbDriver db;

    public BookRepository(DbDriver db)
    {
        this.db = db;
    }

    /**
     * Fetch all books from bible
     *
     * @param bible Bible
     * @return Book[]
     */
    @Override
    public List<Book> fetchByBible(Bible bible) {
        List<String[]> data = this.db.query("SELECT liv_id, liv_nome FROM livros").get();

        List<Book> books = new ArrayList<>();

        for (String[] row : data) {
            books.add(new Book(
                Integer.valueOf(row[ID_COLUMN]),
                row[NAME_COLUMN],
                bible
            ));
        }

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
        String[] row = this.db.query("SELECT liv_id, liv_nome FROM livros WHERE liv_id=" + id).first();

        return new Book(
            Integer.valueOf(row[ID_COLUMN]),
            row[NAME_COLUMN],
            bible
        );
    }
}
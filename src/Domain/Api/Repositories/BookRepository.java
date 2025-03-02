package Domain.Api.Repositories;

import Domain.Entities.Bible;
import Domain.Entities.Book;

import java.util.List;

public interface BookRepository
{
    /**
     * Fetch all books from bible
     *
     * @param bible Bible
     * @return Book[]
     */
    public List<Book> fetchByBible(Bible bible);
}
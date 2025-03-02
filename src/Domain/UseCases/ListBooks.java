package Domain.UseCases;

import Domain.Api.Repositories.BookRepository;
import Domain.Entities.Bible;
import Domain.Entities.Book;

import java.util.List;

public class ListBooks
{
    protected BookRepository bookRepository;

    /**
     * Constructor method
     *
     * @param bookRepository book repository
     */
    public ListBooks(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    /**
     * Handle List books use case
     *
     * @param bible Bible
     * @return Book[]
     */
    public List<Book> handle(Bible bible)
    {
        return this.bookRepository.fetchByBible(bible);
    }
}
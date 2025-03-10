package Domain.UseCases;

import Domain.Api.Repositories.BookRepository;
import Domain.Entities.Bible;
import Domain.Entities.Book;

public class AccessBook {

    protected BookRepository bookRepository;

    /**
     * Access book
     *
     * @param bookRepository BookRepository
     */
    public AccessBook(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    /**
     * Handle access book use case
     *
     * @param id int
     * @return Book
     */
    public Book handle(Bible bible, int id)
    {
        return this.bookRepository.loadById(bible,id);
    }
}
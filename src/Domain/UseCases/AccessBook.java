package Domain.UseCases;

import Domain.Api.Repositories.BookRepository;
import Domain.Entities.Book;

class AccessBook {

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
    public Book handle(int id)
    {
        return this.bookRepository.loadById(id);
    }
}
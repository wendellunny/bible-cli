package App.Cli.Command;

import Domain.Entities.Bible;
import Domain.Entities.Book;
import Domain.UseCases.ListBooks;

import java.util.List;

public class ListBooksOnScreen
{
    protected ListBooks listBooks;

    /**
     * Constructor
     *
     * @param listBooks
     */
    public ListBooksOnScreen(ListBooks listBooks)
    {
        this.listBooks = listBooks;
    }

    /**
     * Run List books on screen command
     *
     * @param bible Bible
     */
    public void run(Bible bible)
    {
        List<Book> books = this.listBooks.handle(bible);

        books.forEach(book -> {
            System.out.println(book.getId() + ". " + book.getName());
        });
    }
}
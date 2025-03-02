package App.Cli.Command;

import Domain.Entities.Book;
import Domain.UseCases.AccessBook;

public class ShowBookOnScreen
{
    protected AccessBook accessBook;

    /**
     * Constructor method
     *
     * @param accessBook AccessBook
     */
    public ShowBookOnScreen(AccessBook accessBook)
    {
        this.accessBook = accessBook;
    }

    /**
     * Run show book on screen command
     *
     * @param id int
     * @return Book
     */
    public Book run(int id)
    {
        Book book = this.accessBook.handle(id);

        System.out.println("O livro escolhido foi: " + book.getName());
        System.out.println();

        return book;
    }
}
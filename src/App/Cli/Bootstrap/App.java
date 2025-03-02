package App.Cli.Bootstrap;

import App.Cli.Command.ListBiblesOnScreen;
import App.AbstractApp;
import App.Cli.Command.ListBooksOnScreen;
import App.Cli.Command.ShowBibleOnScreen;
import App.Cli.Command.ShowBookOnScreen;
import Domain.Entities.Bible;
import Domain.Entities.Book;

import java.io.IOException;
import java.util.Scanner;

public class App extends AbstractApp {
    private final ListBiblesOnScreen listBiblesOnScreen;
    private final ShowBibleOnScreen showBibleOnScreen;
    private final ListBooksOnScreen listBooksOnScreen;
    private final ShowBookOnScreen showBookOnScreen;

    /**
     * Constructor method
     *
     * @param listBiblesOnScreen ListBiblesOnScreen
     * @param showBibleOnScreen ShowBibleOnScreen
     * @param listBooksOnScreen ListBooksOnScreen
     * @param showBookOnScreen ShowBookOnScreen
     */
    public App(
        ListBiblesOnScreen listBiblesOnScreen,
        ShowBibleOnScreen showBibleOnScreen,
        ListBooksOnScreen listBooksOnScreen,
        ShowBookOnScreen showBookOnScreen
    ) {
        this.listBiblesOnScreen = listBiblesOnScreen;
        this.showBibleOnScreen = showBibleOnScreen;
        this.listBooksOnScreen = listBooksOnScreen;
        this.showBookOnScreen = showBookOnScreen;
    }

    /**
     * Run app
     */
    @Override
    public void run()
    {
        int bibleId;
        int bookId;

        this.showWelcomeMessage();
        this.showAllBibles();

        bibleId = this.inputId();
        Bible bible = this.showBibleOnScreen.run(bibleId);
        this.showAllBooks(bible);

        bookId = this.inputId();
        System.out.println(bookId);
        Book book = this.showBookOnScreen.run(bookId);

    }

    /**
     * Show Welcome message
     */
    protected void showWelcomeMessage()
    {
        this.message(this.getWelcome());
    }

    /**
     * Show all bibles
     */
    protected void showAllBibles()
    {
        this.message("Qual tradução vai querer ler hoje?");
        this.listBiblesOnScreen.run();
    }

    /**
     * Input id
     *
     * @return int
     */
    protected int inputId()
    {
        Scanner scan = new Scanner(System.in);
        return  scan.nextInt();
    }

    /**
     * Show all books
     *
     * @param bible Bible
     */
    protected void showAllBooks(Bible bible)
    {
        this.message("Qual livro da bíblia você vai ler hoje?");
        this.listBooksOnScreen.run(bible);
    }


    /**
     * Write message
     *
     * @param message
     */
    protected void message(String message)
    {
        System.out.println(message);
    }
}
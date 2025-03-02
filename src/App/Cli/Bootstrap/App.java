package App.Cli.Bootstrap;

import App.Cli.Command.*;
import App.AbstractApp;
import Domain.Entities.Bible;
import Domain.Entities.Book;
import Domain.Entities.Chapter;

import java.io.IOException;
import java.util.Scanner;

public class App extends AbstractApp {
    private static final int FULL_CHAPTER_CHOICE = 1;
    private static final int VERSE_ONLY_CHOICE = 2;

    private final ListBiblesOnScreen listBiblesOnScreen;
    private final ShowBibleOnScreen showBibleOnScreen;
    private final ListBooksOnScreen listBooksOnScreen;
    private final ShowBookOnScreen showBookOnScreen;
    private final ListChaptersOnScreen listChaptersOnScreen;
    private final ShowChapterOnScreen showChapterOnScreen;
    private final ReadVerses readVerses;

    /**
     * Constructor method
     *
     * @param listBiblesOnScreen ListBiblesOnScreen
     * @param showBibleOnScreen ShowBibleOnScreen
     * @param listBooksOnScreen ListBooksOnScreen
     * @param showBookOnScreen ShowBookOnScreen
     * @param listChaptersOnScreen ListChaptersOnScreen
     * @param showChapterOnScreen ShowChapterOnScreen
     */
    public App(
        ListBiblesOnScreen listBiblesOnScreen,
        ShowBibleOnScreen showBibleOnScreen,
        ListBooksOnScreen listBooksOnScreen,
        ShowBookOnScreen showBookOnScreen,
        ListChaptersOnScreen listChaptersOnScreen,
        ShowChapterOnScreen showChapterOnScreen,
        ReadVerses readVerses
    ) {
        this.listBiblesOnScreen = listBiblesOnScreen;
        this.showBibleOnScreen = showBibleOnScreen;
        this.listBooksOnScreen = listBooksOnScreen;
        this.showBookOnScreen = showBookOnScreen;
        this.listChaptersOnScreen = listChaptersOnScreen;
        this.showChapterOnScreen = showChapterOnScreen;
        this.readVerses = readVerses;
    }

    /**
     * Run app
     */
    @Override
    public void run()
    {
        int bibleId;
        int bookId;
        int chapterNumber;
        int readChoice;

        this.showWelcomeMessage();
        this.showAllBibles();

        bibleId = this.inputId();
        Bible bible = this.showBibleOnScreen.run(bibleId);
        this.showAllBooks(bible);

        bookId = this.inputId();
        Book book = this.showBookOnScreen.run(bookId);
        this.showAllChapters(book);

        chapterNumber = this.inputId();
        Chapter chapter = this.showChapterOnScreen.run(book, chapterNumber);

        this.message("Escolha o que quer fazer: ");
        this.message("1. Ler capítulo completo: ");
        this.message("2. Escolher somente um versículo");

        readChoice = this.inputId();

        switch (readChoice) {
            case FULL_CHAPTER_CHOICE:
                this.readVerses.run(chapter);
                break;
            case VERSE_ONLY_CHOICE:
                break;
        }
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

    protected void showAllChapters(Book book)
    {
        this.message("Escolha o capítulo");
        this.listChaptersOnScreen.run(book);
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
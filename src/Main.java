import App.AbstractApp;
import App.Cli.Command.*;
import Domain.UseCases.*;
import Infra.Repositories.Mock.BibleRepository;
import Infra.Repositories.Mock.BookRepository;
import Infra.Repositories.Mock.ChapterRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Domain.Api.Repositories.BibleRepository bibleRepository = new BibleRepository();
        ListBibles listBibles = new ListBibles(bibleRepository);
        ListBiblesOnScreen listBiblesOnScreen = new ListBiblesOnScreen(
            listBibles
        );

        AccessBible accessBible = new AccessBible(bibleRepository);
        ShowBibleOnScreen showBibleOnScreen = new ShowBibleOnScreen(accessBible);

        Domain.Api.Repositories.BookRepository bookRepository = new BookRepository();
        ListBooks listBooks = new ListBooks(bookRepository);
        ListBooksOnScreen listBooksOnScreen = new ListBooksOnScreen(listBooks);

        AccessBook accessBook = new AccessBook(bookRepository);
        ShowBookOnScreen showBookOnScreen = new ShowBookOnScreen(accessBook);

        Domain.Api.Repositories.ChapterRepository chapterRepository = new ChapterRepository();
        ListChapters listChapters = new ListChapters(chapterRepository);
        ListChaptersOnScreen listChaptersOnScreen = new ListChaptersOnScreen(listChapters);

        AbstractApp app = new App.Cli.Bootstrap.App(
            listBiblesOnScreen,
            showBibleOnScreen,
            listBooksOnScreen,
            showBookOnScreen,
            listChaptersOnScreen
        );

        app.run();
    }
}
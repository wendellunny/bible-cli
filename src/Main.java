import App.AbstractApp;
import App.Cli.Command.ListBiblesOnScreen;
import App.Cli.Command.ListBooksOnScreen;
import App.Cli.Command.ShowBibleOnScreen;
import Domain.UseCases.AccessBible;
import Domain.UseCases.ListBibles;
import Domain.UseCases.ListBooks;
import Infra.Repositories.Mock.BibleRepository;
import Infra.Repositories.Mock.BookRepository;

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

        AbstractApp app = new App.Cli.Bootstrap.App(
            listBiblesOnScreen,
            showBibleOnScreen,
            listBooksOnScreen
        );

        app.run();
    }
}
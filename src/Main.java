import App.AbstractApp;
import App.Cli.Command.ListBiblesOnScreen;
import App.Cli.Command.ShowBibleOnScreen;
import Domain.UseCases.AccessBible;
import Domain.UseCases.ListBibles;
import Infra.Repositories.Mock.BibleRepository;

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

        AbstractApp app = new App.Cli.Bootstrap.App(
            listBiblesOnScreen,
            showBibleOnScreen
        );

        app.run();
    }
}
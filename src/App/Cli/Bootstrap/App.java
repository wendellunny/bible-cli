package App.Cli.Bootstrap;

import App.Cli.Command.ListBiblesOnScreen;
import App.AbstractApp;
import App.Cli.Command.ShowBibleOnScreen;
import Domain.Entities.Bible;

import java.io.IOException;

public class App extends AbstractApp {
    private final ListBiblesOnScreen listBiblesOnScreen;
    private final ShowBibleOnScreen showBibleOnScreen;

    /**
     * Constructor method
     *
     * @param listBiblesOnScreen ListBiblesOnScreen
     * @param showBibleOnScreen ShowBibleOnScreen
     */
    public App(
        ListBiblesOnScreen listBiblesOnScreen,
        ShowBibleOnScreen showBibleOnScreen
    ) {
        this.listBiblesOnScreen = listBiblesOnScreen;
        this.showBibleOnScreen = showBibleOnScreen;
    }

    /**
     * Run app
     */
    @Override
    public void run()
    {
        int bibleId;

        this.showWelcomeMessage();
        this.showAllBibles();

        bibleId = this.inputBibleId();
        Bible bible = this.showBibleOnScreen.run(bibleId);
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
     * Input bible id
     *
     * @return int
     */
    protected int inputBibleId()
    {
        try {
            return System.in.read();
        } catch (IOException e) {
            return 0;
        }
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
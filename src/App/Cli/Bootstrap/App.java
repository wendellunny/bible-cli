package App.Cli.Bootstrap;

import App.Cli.Command.ListBiblesOnScreen;
import App.AbstractApp;

import java.io.IOException;

public class App extends AbstractApp {
    private ListBiblesOnScreen listBiblesOnScreen;

    /**
     * Constructor method
     *
     * @param listBiblesOnScreen
     */
    public App(ListBiblesOnScreen listBiblesOnScreen)
    {
        this.listBiblesOnScreen = listBiblesOnScreen;
    }

    /**
     * Run app
     */
    @Override
    public void run()
    {
        this.message(this.getWelcome());
        this.message("Qual tradução vai querer ler hoje?");
        this.listBiblesOnScreen.run();

        try {
            int bibleId = System.in.read();
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
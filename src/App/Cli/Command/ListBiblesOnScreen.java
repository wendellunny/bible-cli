package App.Cli.Command;

import Domain.Entities.Bible;
import Domain.UseCases.ListBibles;

import java.util.List;

public class ListBiblesOnScreen {

    protected ListBibles listBibles;

    /**
     * Constructor method
     *
     * @param listBibles ListBibles
     */
    public ListBiblesOnScreen(ListBibles listBibles)
    {
        this.listBibles = listBibles;
    }

    /**
     * Run list bibles on screen
     */
    public void run()
    {
        List<Bible> bibles = this.listBibles.handle();

        bibles.forEach(bible -> System.out.println(
            bible.getId() + ". " +bible.getTranslation()
        ));

        System.out.println();
    }
}
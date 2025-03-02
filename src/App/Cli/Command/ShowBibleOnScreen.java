package App.Cli.Command;

import Domain.Entities.Bible;
import Domain.UseCases.AccessBible;

public class ShowBibleOnScreen
{
    protected AccessBible accessBible;

    /**
     * Constructor method
     *
     * @param accessBible AccessBible
     */
    public ShowBibleOnScreen(AccessBible accessBible)
    {
        this.accessBible = accessBible;
    }

    /**
     * Run show bible on screen command
     *
     * @param bibleId int
     */
    public void run(int bibleId)
    {
        Bible bible = this.accessBible.handle(bibleId);

        System.out.println("Tradução escolhida: " + bible.getTranslation());
        System.out.println();
    }
}
package App.Cli.Command;

import Domain.Entities.Chapter;
import Domain.Entities.Verse;
import Domain.UseCases.ListVerses;

import java.util.List;

public class ListVersesOnScreen
{

    protected ListVerses listVerses;

    /**
     * Constructor method
     *
     * @param listVerses ListVerses
     */
    public ListVersesOnScreen(ListVerses listVerses)
    {
        this.listVerses = listVerses;
    }

    /**
     * Run list verses on screen command
     *
     * @param chapter Chapter
     */
    public void run(Chapter chapter)
    {
        List<Verse> verses = this.listVerses.handle(chapter);

        String list = "";

        for (Verse verse : verses) {
            list += "\"" + verse.getNumber() + "\", ";
        }

        System.out.println(list);
    }
}
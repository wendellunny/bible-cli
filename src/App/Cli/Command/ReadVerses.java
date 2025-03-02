package App.Cli.Command;

import Domain.Entities.Chapter;
import Domain.Entities.Verse;
import Domain.UseCases.ListVerses;

import java.util.List;

public class ReadVerses {

    protected ListVerses listVerses;

    /**
     * Constructor method
     *
     * @param listVerses ListVerses
     */
    public ReadVerses(ListVerses listVerses)
    {
        this.listVerses = listVerses;
    }

    /**
     * Run Read verses cmmand
     *
     * @param chapter Chapter
     */
    public void run(Chapter chapter)
    {
        List<Verse> verses = this.listVerses.handle(chapter);

        System.out.println(chapter.getBook().getName() + " " + chapter.getNumber() + ":");

        verses.forEach(
            (verse) -> System.out.println(verse.getNumber() + ". " + verse.getText())
        );
    }
}
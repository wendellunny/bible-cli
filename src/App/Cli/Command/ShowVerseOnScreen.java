package App.Cli.Command;

import Domain.Entities.Book;
import Domain.Entities.Chapter;
import Domain.Entities.Verse;
import Domain.UseCases.AccessVerse;

public class ShowVerseOnScreen
{
    protected AccessVerse accessVerse;

    /**
     * Constructor method
     *
     * @param accessVerse AccessVerse
     */
    public ShowVerseOnScreen(AccessVerse accessVerse)
    {
        this.accessVerse = accessVerse;
    }

    /**
     * Run show verse on screen command
     *
     * @param chapter Chapter
     * @param number int
     */
    public void run(Chapter chapter, int number)
    {
        Verse verse =  this.accessVerse.handle(chapter, number);
        Book book = chapter.getBook();

        System.out.println(
            book.getName()
            + " "
            + chapter.getNumber()
            + ":"
            + verse.getNumber()
        );

        System.out.println(verse.getText());
    }
}
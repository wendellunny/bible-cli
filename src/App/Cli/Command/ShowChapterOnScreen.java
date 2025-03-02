package App.Cli.Command;

import Domain.Entities.Book;
import Domain.Entities.Chapter;
import Domain.UseCases.AccessChapter;

public class ShowChapterOnScreen {

    protected AccessChapter accessChapter;

    /**
     * Constructor
     *
     * @param accessChapter Access chapter
     */
    public ShowChapterOnScreen(AccessChapter accessChapter)
    {
        this.accessChapter = accessChapter;
    }

    /**
     * Run show chapter on screen command
     *
     * @param book Book
     * @param number int
     * @return Chapter
     */
    public Chapter run(Book book, int number)
    {
        Chapter chapter = this.accessChapter.handle(book, number);

        System.out.println("Capítulo escolhido:");
        System.out.println(book.getName() + " " + number);

        return chapter;
    }
}
package App.Cli.Command;

import Domain.Entities.Book;
import Domain.Entities.Chapter;
import Domain.UseCases.ListChapters;

import java.util.List;

public class ListChaptersOnScreen {

    protected ListChapters listChapters;

    /**
     * Constructor method
     *
     * @param listChapters
     */
    public ListChaptersOnScreen(ListChapters listChapters)
    {
        this.listChapters = listChapters;
    }

    /**
     * Run list chapters on screen command
     *
     * @param book Book
     */
    public void run(Book book)
    {
        List<Chapter> chapters = this.listChapters.handle(book);

        String list = "";

        int i = 1;
        for (Chapter chapter : chapters) {
            list += "\"" + chapter.getNumber() + "\", ";

            if (i % 8 == 0) {
                list += "\n";
            }

            i++;
        }

        System.out.println(list);
    }


}
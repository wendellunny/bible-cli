import App.AbstractApp;
import App.Cli.Command.*;
import Domain.UseCases.*;
import Infra.Api.Drivers.DbDriver;
import Infra.Drivers.DB.Mysql;
import Infra.Repositories.Mock.BibleRepository;
import Infra.Repositories.Mock.BookRepository;
import Infra.Repositories.Mock.ChapterRepository;
import Infra.Repositories.Mock.VerseRepository;
import com.mysql.cj.xdevapi.PreparableStatement;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dotenv env = Dotenv.configure()
            .directory("./")
            .ignoreIfMalformed()
            .ignoreIfMissing()
            .load();

        DbDriver dbDriver = new Mysql(env);

        dbDriver.connect();

        Domain.Api.Repositories.BibleRepository bibleRepository = new BibleRepository();
        ListBibles listBibles = new ListBibles(bibleRepository);
        ListBiblesOnScreen listBiblesOnScreen = new ListBiblesOnScreen(
            listBibles
        );

        AccessBible accessBible = new AccessBible(bibleRepository);
        ShowBibleOnScreen showBibleOnScreen = new ShowBibleOnScreen(accessBible);

        Domain.Api.Repositories.BookRepository bookRepository = new BookRepository();
        ListBooks listBooks = new ListBooks(bookRepository);
        ListBooksOnScreen listBooksOnScreen = new ListBooksOnScreen(listBooks);

        AccessBook accessBook = new AccessBook(bookRepository);
        ShowBookOnScreen showBookOnScreen = new ShowBookOnScreen(accessBook);

        Domain.Api.Repositories.ChapterRepository chapterRepository = new ChapterRepository();
        ListChapters listChapters = new ListChapters(chapterRepository);
        ListChaptersOnScreen listChaptersOnScreen = new ListChaptersOnScreen(listChapters);

        AccessChapter accessChapter = new AccessChapter(chapterRepository);
        ShowChapterOnScreen showChapterOnScreen = new ShowChapterOnScreen(accessChapter);

        Domain.Api.Repositories.VerseRepository verseRepository = new VerseRepository();
        ListVerses listVerses = new ListVerses(verseRepository);
        ReadVerses readVerses = new ReadVerses(listVerses);
        ListVersesOnScreen listVersesOnScreen = new ListVersesOnScreen(listVerses);

        AccessVerse accessVerse = new AccessVerse(verseRepository);
        ShowVerseOnScreen showVerseOnScreen = new ShowVerseOnScreen(accessVerse);

        AbstractApp app = new App.Cli.Bootstrap.App(
            listBiblesOnScreen,
            showBibleOnScreen,
            listBooksOnScreen,
            showBookOnScreen,
            listChaptersOnScreen,
            showChapterOnScreen,
            readVerses,
            listVersesOnScreen,
            showVerseOnScreen
        );

        app.run();

        dbDriver.close();
    }
}
package Infra.Repositories;

import Domain.Entities.Bible;
import Domain.Entities.Book;
import Domain.Entities.Chapter;
import Infra.Api.Drivers.DbDriver;

import java.util.ArrayList;
import java.util.List;

public class ChapterRepository implements Domain.Api.Repositories.ChapterRepository
{
    protected static int ID_COLUMN = 0;
    protected static int NUMBER_COLUMN = 0;

    protected DbDriver db;

    /**
     * Constructor method
     *
     * @param db
     */
    public ChapterRepository(DbDriver db)
    {
        this.db = db;
    }

    /**
     * Fetch all chapters by book
     *
     * @param book
     * @return Chapter[]
     */
    @Override
    public List<Chapter> fetchByBook(Book book) {
        Bible bible = book.getBible();

        String[] row = this.db.query(
            "SELECT ver_capitulo, ver_vrs_id, ver_liv_id FROM versiculos "
            + "WHERE ver_vrs_id=" + bible.getId() + " "
            + "AND ver_liv_id=" + book.getId() + " "
            + "ORDER BY ver_capitulo DESC "
            + "LIMIT 1"
        ).first();

        int chaptersCount = Integer.valueOf(row[NUMBER_COLUMN]);

        List<Chapter> chapters = new ArrayList<Chapter>();

        for (int i = 1; i <= chaptersCount; i++) {
            chapters.add(new Chapter(i, i, book));
        }

        return chapters;
    }

    /**
     * Load chapter by number
     *
     * @param book
     * @param number int
     * @return Chapter
     */
    @Override
    public Chapter loadByNumber(Book book, int number) {
        return new Chapter(number, number, book);
    }
}
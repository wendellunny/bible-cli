package Infra.Repositories;

import Domain.Entities.Bible;
import Domain.Entities.Book;
import Domain.Entities.Chapter;
import Domain.Entities.Verse;
import Infra.Api.Drivers.DbDriver;

import java.util.ArrayList;
import java.util.List;

public class VerseRepository implements Domain.Api.Repositories.VerseRepository
{

    protected static int ID_COLUMN = 0;
    protected static int NUMBER_COLUMN = 4;
    protected static int TEXT_COLUMN = 5;

    protected DbDriver db;


    public VerseRepository(DbDriver db)
    {
        this.db = db;
    }

    /**
     * Fetch all verses from chapter
     *
     * @param chapter Chapter
     * @return Verse[]
     */
    @Override
    public List<Verse> fetchByChapter(Chapter chapter) {

        Book book = chapter.getBook();
        Bible bible = book.getBible();

        List<String[]> data = this.db.query(
            "SELECT * FROM versiculos "
            + "WHERE ver_vrs_id=" + bible.getId() + " "
            + "AND ver_liv_id=" + book.getId() + " "
            + "AND ver_capitulo=" + chapter.getNumber()
        ).get();

        List<Verse> verses = new ArrayList<Verse>();

        for (String[] row : data) {
            verses.add(new Verse(
                Integer.valueOf(row[ID_COLUMN]),
                Integer.valueOf(row[NUMBER_COLUMN]),
                row[TEXT_COLUMN],
                chapter
            ));
        }

        return verses;
    }

    /**
     * Load verse by number
     *
     * @param chapter Chapter
     * @param number  int
     * @return Verse
     */
    @Override
    public Verse loadByNumber(Chapter chapter, int number) {
        Book book = chapter.getBook();
        Bible bible = book.getBible();

        String[] row = this.db.query(
            "SELECT * FROM versiculos "
                + "WHERE ver_vrs_id=" + bible.getId() + " "
                + "AND ver_liv_id=" + book.getId() + " "
                + "AND ver_capitulo=" + chapter.getNumber() + " "
                + "AND ver_versiculo=" + number + " "
                + "LIMIT 1"
        ).first();

        return  new Verse(
            Integer.valueOf(row[ID_COLUMN]),
            Integer.valueOf(row[NUMBER_COLUMN]),
            row[TEXT_COLUMN],
            chapter
        );
    }
}
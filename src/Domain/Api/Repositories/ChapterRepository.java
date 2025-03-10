package Domain.Api.Repositories;

import Domain.Entities.Book;
import Domain.Entities.Chapter;

import java.util.List;

public interface ChapterRepository {

    /**
     * Fetch all chapters by book
     *
     * @return Chapter[]
     */
    public List<Chapter> fetchByBook(Book book);

    /**
     * Load chapter by number
     *
     * @param number int
     * @return Chapter
     */
    public Chapter loadByNumber(Book book, int number);
}
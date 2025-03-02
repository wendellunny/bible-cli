package Infra.Repositories.Mock;

import Domain.Entities.Book;
import Domain.Entities.Chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterRepository implements Domain.Api.Repositories.ChapterRepository {

    /**
     * Fetch all chapters by book
     *
     * @param book Book
     * @return Chapter[]
     */
    @Override
    public List<Chapter> fetchByBook(Book book) {
        List<Chapter> chapters = new ArrayList<Chapter>();

        for (int i = 0; i < 14; i++) {
            chapters.add(new Chapter(i+1, i+1, book));
        }

        return chapters;
    }
}
package Domain.Api.Repositories;

import Domain.Entities.Chapter;
import Domain.Entities.Verse;

import java.util.List;

public interface VerseRepository {

    /**
     * Fetch all verses from chapter
     *
     * @param chapter Chapter
     * @return Verse[]
     */
    public List<Verse> fetchByChapter(Chapter chapter);
}
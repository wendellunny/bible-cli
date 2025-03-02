package Domain.UseCases;

import Domain.Api.Repositories.VerseRepository;
import Domain.Entities.Chapter;
import Domain.Entities.Verse;

import java.util.List;

public class ListVerses {

    protected VerseRepository verseRepository;

    /**
     * Constructor method
     *
     * @param verseRepository VerseRepository
     */
    public ListVerses(VerseRepository verseRepository)
    {
        this.verseRepository = verseRepository;
    }

    /**
     * Handle List verses use case
     *
     * @param chapter Chapter
     * @return Verse[]
     */
    public List<Verse> handle(Chapter chapter)
    {
        return this.verseRepository.fetchByChapter(chapter);
    }
}
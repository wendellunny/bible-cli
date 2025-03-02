package Domain.UseCases;

import Domain.Api.Repositories.VerseRepository;
import Domain.Entities.Chapter;
import Domain.Entities.Verse;

public class AccessVerse
{
    protected VerseRepository verseRepository;

    /**
     * Constructor method
     *
     * @param verseRepository VerseRepository
     */
    public AccessVerse(VerseRepository verseRepository)
    {
        this.verseRepository = verseRepository;
    }

    /**
     * Handle access verse use case
     *
     * @param chapter Chapter
     * @param number int
     * @return Verse
     */
    public Verse handle(Chapter chapter, int number)
    {
        return this.verseRepository.loadByNumber(chapter, number);
    }
}
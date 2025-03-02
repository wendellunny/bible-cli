package Domain.UseCases;

import Domain.Api.Repositories.ChapterRepository;
import Domain.Entities.Chapter;

public class AccessChapter {
    protected ChapterRepository chapterRepository;

    /**
     * Constructor method
     *
     * @param chapterRepository ChapterRepository
     */
    public AccessChapter(ChapterRepository chapterRepository)
    {
        this.chapterRepository = chapterRepository;
    }

    /**
     * Handle Access chapter use case
     *
     * @param number int
     * @return Chapter
     */
    public Chapter handle(int number)
    {
        return this.chapterRepository.loadByNumber(number);
    }
}
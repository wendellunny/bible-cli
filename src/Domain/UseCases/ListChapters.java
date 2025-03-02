package Domain.UseCases;

import Domain.Api.Repositories.ChapterRepository;
import Domain.Entities.Book;
import Domain.Entities.Chapter;

import java.util.List;

class ListChapters
{
    protected ChapterRepository chapterRepository;

    /**
     * Constructor method
     *
     * @param chapterRepository ChapterRepository
     */
    public ListChapters(ChapterRepository chapterRepository)
    {
        this.chapterRepository = chapterRepository;
    }

    /**
     * handle List chapters use case
     *
     * @param book Book
     * @return Chapter[]
     */
    public List<Chapter> handle(Book book)
    {
        return this.chapterRepository.fetchByBook(book);
    }
}
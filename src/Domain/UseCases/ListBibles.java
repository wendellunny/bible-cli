package Domain.UseCases;

import Domain.Api.Repositories.BibleRepository;
import Domain.Entities.Bible;

import java.util.List;

public class ListBibles
{
    protected BibleRepository bibleRepository;

    /**
     * Constructor method
     *
     * @param bibleRepository BibleRepository
     */
    public ListBibles(BibleRepository bibleRepository)
    {
        this.bibleRepository = bibleRepository;
    }

    /**
     * Handle list bibles use case
     *
     * @return Bible[]
     */
    public List<Bible> handle()
    {
        return this.bibleRepository.fetchAll();
    }
}
package Domain.UseCases;

import Domain.Api.Repositories.BibleRepository;
import Domain.Entities.Bible;

public class AccessBible
{
    protected BibleRepository bibleRepository;

    /**
     * Constructor method
     *
     * @param bibleRepository BibleRepository
     */
    public AccessBible(BibleRepository bibleRepository)
    {
        this.bibleRepository = bibleRepository;
    }

    /**
     * Handle Access Bible use case
     *
     * @return Bible
     */
    public Bible handle(int id)
    {
        return this.bibleRepository.loadById(id);
    }
}
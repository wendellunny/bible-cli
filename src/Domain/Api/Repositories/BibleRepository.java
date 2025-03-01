package Domain.Api.Repositories;

import Domain.Entities.Bible;

public interface BibleRepository
{
    /**
     * Fetch all bibles
     *
     * @return Bible[]
     */
    public Bible[] fetchAll();
}
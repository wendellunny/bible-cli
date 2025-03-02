package Domain.Api.Repositories;

import Domain.Entities.Bible;

import java.util.List;

public interface BibleRepository
{
    /**
     * Fetch all bibles
     *
     * @return Bible[]
     */
    public List<Bible> fetchAll();
}
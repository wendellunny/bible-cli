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

    /**
     * Load bible by id
     *
     * @param id int
     * @return Bible
     */
    public Bible loadById(int id);
}
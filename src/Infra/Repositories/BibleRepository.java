package Infra.Repositories;

import Domain.Entities.Bible;
import Infra.Api.Drivers.DbDriver;

import java.util.ArrayList;
import java.util.List;

public class BibleRepository implements Domain.Api.Repositories.BibleRepository
{
    protected static int ID_COLUMN = 0;
    protected static int TRANSLATION_COLUMN = 1;

    protected DbDriver db;

    /**
     * Constructor method
     *
     * @param db
     */
    public BibleRepository(DbDriver db)
    {
        this.db = db;
    }

    /**
     * Fetch all bibles
     *
     * @return Bible[]
     */
    @Override
    public List<Bible> fetchAll() {
        List<String[]> data = this.db.query("SELECT * FROM versoes").get();
        List<Bible> bibles = new ArrayList<>();

        for (String[] row : data) {
            bibles.add(new Bible(
                Integer.valueOf(row[ID_COLUMN]),
                row[TRANSLATION_COLUMN]
            ));
        }

        return bibles;
    }

    /**
     * Load bible by id
     *
     * @param id int
     * @return Bible
     */
    @Override
    public Bible loadById(int id) {
        String[] row = this.db.query("SELECT * FROM versoes WHERE vrs_id=" + id).first();

        return new Bible(
            Integer.valueOf(row[ID_COLUMN]),
            row[TRANSLATION_COLUMN]
        );
    }
}
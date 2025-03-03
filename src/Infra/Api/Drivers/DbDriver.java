package Infra.Api.Drivers;

import java.util.List;

public interface DbDriver
{
    /**
     * Connect to driver and database
     */
    public void connect();

    /**
     * Query db
     *
     * @param query String
     * @return DbDriver
     */
    public DbDriver query(String query);

    /**
     * Get select data
     *
     * @return String[]
     */
    public List<String[]> get();

    /**
     * Get select first
     *
     * @return String[]
     */
    public String[] first();

    /**
     * Close connection
     */
    public void close();
}
package Domain.Entities;

public class Book {
    protected int id;
    protected String name;
    protected Bible bible;

    /**
     * Constructor method
     *
     * @param id int
     * @param name String
     */
    public Book(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    /**
     * Get id
     *
     * @return int
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * Get name
     *
     * @return String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Get bible
     *
     * @return Bible
     */
    public Bible getBible()
    {
        return this.bible;
    }
}

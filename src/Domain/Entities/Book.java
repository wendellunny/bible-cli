package Domain.Entities;

public class Book {
    protected int id;
    protected String name;
    protected Bible bible;
    protected Chapter[] chapters;

    /**
     * Constructor method
     *
     * @param id int
     * @param name String
     */
    public Book(int id, String name, Chapter[] chapters)
    {
        this.id = id;
        this.name = name;
        this.chapters = chapters;
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

    /**
     * Get chapters
     *
     * @return Chapter[]
     */
    public Chapter[] getChapters()
    {
        return this.chapters;
    }
}

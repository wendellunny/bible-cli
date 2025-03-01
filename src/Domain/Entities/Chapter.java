package Domain.Entities;

public class Chapter
{
    protected int id;
    protected int number;
    protected Book book;

    /**
     * Constructor method
     *
     * @param id int
     * @param number int
     * @param book Book
     */
    public Chapter(int id, int number, Book book)
    {
        this.id = id;
        this.number = number;
        this.book = book;
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
     * Get number
     *
     * @return int
     */
    public int getNumber()
    {
        return this.number;
    }

    /**
     * Get book
     *
     * @return Book
     */
    public Book getBook()
    {
        return this.book;
    }
}
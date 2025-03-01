package Domain.Entities;

public class Verse {
    protected int id;
    protected int number;
    protected String text;
    protected Chapter chapter;

    /**
     * Constructor method
     *
     * @param id int
     * @param number int
     * @param text String
     * @param chapter Chapter
     */
    public Verse(int id, int number, String text, Chapter chapter)
    {
        this.id = id;
        this.number = number;
        this.text = text;
        this.chapter = chapter;
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
     * Get text
     *
     * @return String
     */
    public String getText()
    {
        return this.text;
    }

    /**
     * Get chapter
     *
     * @return chapter
     */
    public Chapter getChapter()
    {
        return this.chapter;
    }
}
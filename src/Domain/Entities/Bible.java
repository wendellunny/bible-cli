package Domain.Entities;

public class Bible {
    protected int id;
    protected String translation;

    /**
     * Constructor method
     *
     * @param id int
     * @param translation String
     */
    public Bible(int id, String translation)
    {
        this.id = id;
        this.translation = translation;
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
     * Get translation
     *
     * @return String
     */
    public String getTranslation()
    {
        return this.translation;
    }
}
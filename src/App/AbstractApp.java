package App;

public abstract class AbstractApp {

    /**
     * Run app
     */
    abstract public void run();

    /**
     * Get welcome
     *
     * @return String
     */
    protected String getWelcome()
    {
        return "Olá! Seja bem-vindo ao app " + this.getAppName();
    }

    /**
     * Get app name
     *
     * @return String
     */
    protected String getAppName()
    {
        return "Bíblia Sagrada";
    }
}
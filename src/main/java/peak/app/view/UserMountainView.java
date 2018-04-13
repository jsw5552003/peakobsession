package peak.app.view;

public class UserMountainView extends MountainView {

    private String date;
    private boolean completed;

    public UserMountainView(String name, int elevation, String date, boolean completed)
    {
        super(name, elevation);
        this.date = date;
        this.completed = completed;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public String getYear()
    {
        if (date != null && date.length() > 4)
            return date.substring(date.length() - 4);
        else
            return "";
    }

}

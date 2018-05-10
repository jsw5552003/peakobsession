package peak.app.view;

public class FeatureView {

    String name;

    String username;

    String description;

    int numVotes;

    String acceptedDate;

    String createdDate;

    String completedDate;

    boolean userVoted;

    public FeatureView()
    {
    }

    public FeatureView(String name, String description, int numVotes, boolean userVoted)
    {
        super();
        this.name = name;
        this.description = description;
        this.numVotes = numVotes;
        this.userVoted = userVoted;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getNumVotes()
    {
        return numVotes;
    }

    public void setNumVotes(int numVotes)
    {
        this.numVotes = numVotes;
    }

    public boolean isUserVoted()
    {
        return userVoted;
    }

    public void setUserVoted(boolean userVoted)
    {
        this.userVoted = userVoted;
    }

    public String getAcceptedDate()
    {
        return acceptedDate;
    }

    public void setAcceptedDate(String acceptedDate)
    {
        this.acceptedDate = acceptedDate;
    }

    public String getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(String createdDate)
    {
        this.createdDate = createdDate;
    }

    public String getCompletedDate()
    {
        return completedDate;
    }

    public void setCompletedDate(String completedDate)
    {
        this.completedDate = completedDate;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

}

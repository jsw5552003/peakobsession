package peak.app.view;

import peak.app.Constants;

public class ListView {
    
    private String name;
    
    private String type;
    
    private String description;
    
    private String friend;

    public ListView() {}
    
    public ListView(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getType()
    {
        return Constants.LIST_TYPE_MOUNTAIN;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }

    public boolean isMountainList()
    {
        return Constants.LIST_TYPE_MOUNTAIN.equals(getType());
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

}

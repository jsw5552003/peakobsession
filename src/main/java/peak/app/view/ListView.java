package peak.app.view;

import peak.app.Constants;

public class ListView {
    
    private String name;
    
    private String type;
    
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
    
    public boolean isMountainList()
    {
        return Constants.LIST_TYPE_MOUNTAIN.equals(getType());
    }

}

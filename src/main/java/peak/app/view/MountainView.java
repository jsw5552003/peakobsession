package peak.app.view;

public class MountainView {

    private String name;
    
    private int elevation;
    
    private String state;
    
    public MountainView() {}
    
    public MountainView(String name, int elevation)
    {
        this.name = name;
        this.elevation = elevation;
    }
    
    public MountainView(String name, int elevation, String state)
    {
        this.name = name;
        this.elevation = elevation;
        this.state = state;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getElevation()
    {
        return elevation;
    }

    public void setElevation(int elevation)
    {
        this.elevation = elevation;
    }
    
    public void setState(String state)
    {
    	this.state = state;
    }
    
    public String getState()
    {
    	return this.state;
    }
}

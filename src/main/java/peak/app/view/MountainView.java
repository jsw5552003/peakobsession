package peak.app.view;

public class MountainView {

    String name;
    
    int elevation;
    
    public MountainView() {}
    
    public MountainView(String name, int elevation)
    {
        this.name = name;
        this.elevation = elevation;
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
}

package peak.app.view;

import java.util.ArrayList;
import java.util.List;

public class MountainListView extends ListView {

    List<MountainView> mountains;

    public List<MountainView> getMountains()
    {
        return mountains;
    }

    public void setMountains(List<MountainView> mountains)
    {
        this.mountains = mountains;
    }
    
    public void addMountain(MountainView mountain)
    {
        if(mountains == null)
            mountains = new ArrayList<>();
        
        mountains.add(mountain);
    }
}

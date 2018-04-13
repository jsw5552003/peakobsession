package peak.app.view;

import java.util.ArrayList;
import java.util.List;

public class UserMountainListView extends ListView {

    List<UserMountainView> mountains;

    public List<UserMountainView> getMountains()
    {
        return mountains;
    }

    public void setMountains(List<UserMountainView> mountains)
    {
        this.mountains = mountains;
    }

    public void addMountain(UserMountainView mountain)
    {
        if (mountains == null)
            mountains = new ArrayList<>();

        mountains.add(mountain);
    }

}

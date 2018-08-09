package peak.app.view;

import java.util.ArrayList;
import java.util.List;

public class HikeView {
    private Long id;
    
    private String date;
    
    private String miles;
    
    private String elevation;
    
    private List<String> mountains;

    private List<String> friends;

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getMiles()
    {
        return miles;
    }

    public void setMiles(String miles)
    {
        this.miles = miles;
    }

	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public List<String> getMountains() {
		return mountains;
	}

	public void setMountains(List<String> mountains) {
		this.mountains = mountains;
	}
	
	public void addMountain(String mountain)
	{
		if(this.mountains == null)
			this.mountains = new ArrayList<String>();
		this.mountains.add(mountain);
	}

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public void addFriend(String friend) {
        if (this.friends == null)
            this.friends = new ArrayList<String>();
        this.friends.add(friend);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

}

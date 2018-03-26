package peak.app.view;

import java.util.ArrayList;
import java.util.List;

public class HikeView {
    
    private String date;
    
    private String miles;
    
    private String elevation;
    
    private List<String> mountains;

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
    

}

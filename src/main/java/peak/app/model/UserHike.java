package peak.app.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_HIKES")
public class UserHike {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private LocalDate date;
    
    private double mileage;
    
    private int elevation;
    
    @ManyToMany
    @JoinTable(name="USER_HIKES_MOUNTAINS",
            joinColumns=@JoinColumn(name="USER_HIKE_ID"),
            inverseJoinColumns=@JoinColumn(name="MOUNTAIN_ID"))
    private List<Mountain> mountains;

    public UserHike() {
		super();
	}  

	public UserHike(LocalDate hikeDate, double mileage, int elevation) {
		super();
		this.date = hikeDate;
		this.mileage = mileage;
		this.elevation = elevation;
	}

	public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public double getMileage()
    {
        return mileage;
    }

    public void setMileage(double mileage)
    {
        this.mileage = mileage;
    }
    
    public int getElevation()
    {
    	return elevation;
    }
    
    public void setElevation(int elevation)
    {
    	this.elevation = elevation;
    }

    public List<Mountain> getMountains()
    {
        return mountains;
    }

    public void setMountains(List<Mountain> mountains)
    {
        this.mountains = mountains;
    }
    
    public void addMountain(Mountain mountain)
    {
        if(this.mountains == null)
            mountains = new ArrayList<Mountain>();
        mountains.add(mountain);
    }

}
